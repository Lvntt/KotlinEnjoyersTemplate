package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones

import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenViewModel
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.model.MapObjectZonesEffect
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.model.MapObjectZonesEvent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.model.MapObjectZonesState
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

    override fun acceptNavigationParams(params: Any) {}

    override fun onEvent(event: MapObjectZonesEvent) {
        when (event) {
            MapObjectZonesEvent.CancelClicked -> {
                //navigate to main
            }
            MapObjectZonesEvent.ContinueClicked -> {
                //navigate to next
            }
            is MapObjectZonesEvent.CreateZoneClicked -> {
                //navigate to zone creation
                _effects.tryEmit(MapObjectZonesEffect.CloseBottomSheet)
                _effects.tryEmit(MapObjectZonesEffect.NavigateToZoneCreation(event.mode))
            }
            is MapObjectZonesEvent.MenuOpenClicked -> {
                _state.update { state -> state.copy(currentZoneMenuType = event.menuType) }
                _effects.tryEmit(MapObjectZonesEffect.OpenBottomSheet)
            }
        }
    }
}