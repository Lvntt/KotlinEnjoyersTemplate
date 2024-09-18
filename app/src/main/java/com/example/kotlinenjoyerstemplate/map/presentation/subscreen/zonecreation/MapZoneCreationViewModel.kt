package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation

import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.Zone
import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.creation.ZoneCreationMode
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenViewModel
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model.MapZoneCreationEffect
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model.MapZoneCreationEvent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model.MapZoneCreationState
import com.mapbox.api.directions.v5.models.RouteOptions
import com.mapbox.navigation.base.extensions.applyDefaultNavigationOptions
import com.mapbox.navigation.base.route.NavigationRoute
import com.mapbox.navigation.base.route.NavigationRouterCallback
import com.mapbox.navigation.base.route.RouterFailure
import com.mapbox.navigation.core.lifecycle.MapboxNavigationApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MapZoneCreationViewModel(private val viewModelScope: CoroutineScope) :
    MapSubScreenViewModel<MapZoneCreationState, MapZoneCreationEvent, MapZoneCreationEffect>() {

    private val _state = MutableStateFlow(MapZoneCreationState())
    override val state = _state.asStateFlow()

    private val _effects = MutableSharedFlow<MapZoneCreationEffect>(extraBufferCapacity = 2)
    override val effects = _effects.asSharedFlow()

    private val routeCallback = object : NavigationRouterCallback {
        override fun onCanceled(
            routeOptions: RouteOptions,
            routerOrigin: String,
        ) {
        }

        override fun onFailure(
            reasons: List<RouterFailure>,
            routeOptions: RouteOptions,
        ) {
            _effects.tryEmit(MapZoneCreationEffect.ShowRouteError)
        }

        override fun onRoutesReady(
            routes: List<NavigationRoute>,
            routerOrigin: String,
        ) {
            routes.firstOrNull()?.directionsRoute?.geometry()
                ?.decodePolyline()?.let { points ->
                    _state.update { state ->
                        state.copy(
                            zonePoints = points
                        )
                    }
                }
        }
    }

    private var currentRouteRequestId = 0L

    override fun acceptNavigationParams(params: Any) {
        if (params is ZoneCreationMode) {
            _state.update { state ->
                state.copy(
                    mode = params,
                    points = emptyList(),
                    zonePoints = emptyList(),
                )
            }
        }
    }

    override fun onEvent(event: MapZoneCreationEvent) {
        when (event) {
            MapZoneCreationEvent.BuildZone -> {
                if (_state.value.points.size < 2) {
                    _state.update { state ->
                        state.copy(
                            zonePoints = emptyList(),
                        )
                    }
                    return
                }
                viewModelScope.launch {
                    when (_state.value.mode) {
                        ZoneCreationMode.POLYLINE, ZoneCreationMode.POLYGON -> _state.update { state ->
                            state.copy(
                                zonePoints = state.points,
                            )
                        }

                        ZoneCreationMode.ROUTE -> {
                            if (currentRouteRequestId != 0L) {
                                MapboxNavigationApp.current()
                                    ?.cancelRouteRequest(currentRouteRequestId)
                            }
                            currentRouteRequestId = MapboxNavigationApp.current()?.requestRoutes(
                                RouteOptions.builder()
                                    .applyDefaultNavigationOptions()
                                    .coordinatesList(_state.value.points).build(),
                                routeCallback,
                            ) ?: 0L
                        }
                    }
                }
            }

            MapZoneCreationEvent.CancelZoneCreationClicked -> {
                _effects.tryEmit(MapZoneCreationEffect.CloseBottomSheet)
                _effects.tryEmit(MapZoneCreationEffect.NavigateBack)
            }

            is MapZoneCreationEvent.PointAdded -> {
                _state.update { state ->
                    state.copy(
                        points = state.points + event.point,
                    )
                }

                onEvent(MapZoneCreationEvent.BuildZone)
            }

            MapZoneCreationEvent.RemoveLastPointClicked -> {
                if (_state.value.points.isEmpty()) return
                _state.update { state ->
                    state.copy(
                        points = state.points.dropLast(1),
                    )
                }

                onEvent(MapZoneCreationEvent.BuildZone)
            }

            MapZoneCreationEvent.SaveZoneClicked -> {
                if (_state.value.zonePoints.isEmpty()) {
                    _effects.tryEmit(MapZoneCreationEffect.ShowNoZoneError)
                    return
                }
                _effects.tryEmit(MapZoneCreationEffect.CloseBottomSheet)
                _effects.tryEmit(
                    MapZoneCreationEffect.NavigateWithNewZone(
                        Zone(
                            _state.value.zonePoints, _state.value.mode.renderMode
                        )
                    )
                )
            }

            MapZoneCreationEvent.MenuOpenClicked -> {
                _effects.tryEmit(MapZoneCreationEffect.OpenBottomSheet)
            }
        }
    }
}