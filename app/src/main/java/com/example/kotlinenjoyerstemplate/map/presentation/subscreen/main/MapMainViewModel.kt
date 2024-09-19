package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main

import com.example.kotlinenjoyerstemplate.map.data.repository.ObjectRepository
import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.Zone
import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.ZoneRenderMode
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenViewModel
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainEffect
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainEvent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainState
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.ObjectInfo
import com.mapbox.geojson.Point
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MapMainViewModel(
    private val repository: ObjectRepository,
    private val viewModelScope: CoroutineScope,
) :
    MapSubScreenViewModel<MapMainState, MapMainEvent, MapMainEffect>() {
    private val _state = MutableStateFlow(MapMainState())
    override val state = _state.asStateFlow()

    private val _effects = MutableSharedFlow<MapMainEffect>(extraBufferCapacity = 1)
    override val effects = _effects.asSharedFlow()

    override fun acceptNavigationParams(params: Any) {}

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val objectInfos = repository.getAllObjectSummaries()
                val mappedObjectInfos = objectInfos.map {
                    val zones = it.zones.map { zone ->
                        Zone(
                            points = zone.points.map { point ->
                                Point.fromLngLat(point.longitude, point.latitude)
                            },
                            renderMode = zone.renderMode
                        )
                    }
                    ObjectInfo(
                        id = it.id,
                        planProgressions = it.planProgressions,
                        viewPoint = getObjectMarkerPosition(zones),
                        zones = zones
                    )
                }
                _state.value = _state.value.copy(objectInfos = mappedObjectInfos)
            } catch (e: Exception) {
                _effects.tryEmit(MapMainEffect.ShowLoadingError)
            }
        }
    }

    override fun onEvent(event: MapMainEvent) {
        when (event) {
            MapMainEvent.AddNewObjectClicked -> {
                _effects.tryEmit(MapMainEffect.NavigateToNewObject)
            }

            is MapMainEvent.ObjectClicked -> {
                _state.value = _state.value.copy(selectedObjectInfoIndex = event.index)
                _effects.tryEmit(MapMainEffect.OpenBottomSheet)
            }

            MapMainEvent.ObjectUnselected -> {
                _state.value = _state.value.copy(selectedObjectInfoIndex = null)
            }

            MapMainEvent.BottomSheetOpened -> {
                _effects.tryEmit(MapMainEffect.OpenBottomSheet)
            }
        }
    }

    private fun getObjectMarkerPosition(zones: List<Zone>): Point {
        if (zones.size == 1) {
            val zone = zones.first()
            return getObjectMarkerPosition(zone)
        } else {
            var longitudeSum = 0.0
            var latitudeSum = 0.0
            zones.forEach {
                val center = getObjectMarkerPosition(it)
                longitudeSum += center.longitude()
                latitudeSum += center.latitude()
            }
            return Point.fromLngLat(
                longitudeSum / zones.size,
                latitudeSum / zones.size,
            )
        }
    }

    private fun getObjectMarkerPosition(zone: Zone): Point {
        if (zone.points.size < 2) {
            return Point.fromLngLat(0.0, 0.0)
        }
        when (zone.renderMode) {
            ZoneRenderMode.POLYLINE -> {
                val firstPoint = zone.points[zone.points.size / 2 - 1]
                val secondPoint = zone.points[zone.points.size / 2]
                return Point.fromLngLat(
                    (firstPoint.longitude() + secondPoint.longitude()) / 2,
                    (firstPoint.latitude() + secondPoint.latitude()) / 2
                )
            }

            ZoneRenderMode.POLYGON -> {
                var longitudeSum = 0.0
                var latitudeSum = 0.0
                zone.points.forEach {
                    longitudeSum += it.longitude()
                    latitudeSum += it.latitude()
                }
                return Point.fromLngLat(
                    longitudeSum / zone.points.size,
                    latitudeSum / zone.points.size
                )
            }
        }
    }

}