package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones

import com.example.kotlinenjoyerstemplate.map.data.model.ZoneList
import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.Zone
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenViewModel
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.model.MapObjectZonesEffect
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.model.MapObjectZonesEvent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.model.MapObjectZonesState
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MapObjectZonesViewModel :
    MapSubScreenViewModel<MapObjectZonesState, MapObjectZonesEvent, MapObjectZonesEffect>() {
    private val _state = MutableStateFlow(MapObjectZonesState())
    override val state = _state.asStateFlow()

    private val _effects = MutableSharedFlow<MapObjectZonesEffect>(extraBufferCapacity = 2)
    override val effects = _effects.asSharedFlow()

    override fun acceptNavigationParams(params: Any) {
        if (params is Zone) {
            _state.update { state -> state.copy(zones = state.zones + params) }
        } else {
            _state.update { state -> state.copy(zones = emptyList()) }
        }
    }

    override fun onEvent(event: MapObjectZonesEvent) {
        when (event) {
            MapObjectZonesEvent.CancelClicked -> {
                _effects.tryEmit(MapObjectZonesEffect.NavigateBack)
            }
            MapObjectZonesEvent.ContinueClicked -> {
                if (_state.value.zones.isEmpty()) {
                    _effects.tryEmit(MapObjectZonesEffect.ShowNoZonesError)
                } else {
                    val converted = ZoneList(_state.value.zones.map { zone ->
                        com.example.kotlinenjoyerstemplate.map.data.model.Zone(
                            points = zone.points.map { point ->
                                com.example.kotlinenjoyerstemplate.map.data.model.Point(
                                    latitude = point.latitude(),
                                    longitude = point.longitude()
                                )
                            },
                            renderMode = zone.renderMode
                        )
                    })
                    _effects.tryEmit(MapObjectZonesEffect.Continue(
                        Gson().toJson(converted)
                    ))
                }
            }
            is MapObjectZonesEvent.CreateZoneClicked -> {
                _effects.tryEmit(MapObjectZonesEffect.CloseBottomSheet)
                _effects.tryEmit(MapObjectZonesEffect.NavigateToZoneCreation(event.mode))
            }
            is MapObjectZonesEvent.MenuOpenClicked -> {
                _state.update { state -> state.copy(currentZoneMenuType = event.menuType) }
                _effects.tryEmit(MapObjectZonesEffect.OpenBottomSheet)
            }

            is MapObjectZonesEvent.ZoneActionsClicked -> {
                _state.update { state -> state.copy(actionPromptZoneIndex = event.zoneIndex) }
            }
            MapObjectZonesEvent.ZoneDeleteClicked -> {
                _state.value.actionPromptZoneIndex?.let { index ->
                    _state.update { state ->
                        state.copy(
                            zones = state.zones.filterIndexed { i, _ -> i != index },
                            actionPromptZoneIndex = null
                        )
                    }
                }
            }

            MapObjectZonesEvent.ZoneActionsDismissed -> {
                _state.update { state -> state.copy(actionPromptZoneIndex = null) }
            }
        }
    }
}