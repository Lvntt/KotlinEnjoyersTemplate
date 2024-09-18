package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation

import android.util.Log
import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.creation.ZoneCreationMode
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenViewModel
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model.MapZoneCreationEffect
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model.MapZoneCreationEvent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model.MapZoneCreationState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class MapZoneCreationViewModel : MapSubScreenViewModel<MapZoneCreationState, MapZoneCreationEvent, MapZoneCreationEffect>() {

    private val _state = MutableStateFlow(MapZoneCreationState())
    override val state = _state.asStateFlow()

    private val _effects = MutableSharedFlow<MapZoneCreationEffect>(extraBufferCapacity = 1)
    override val effects = _effects.asSharedFlow()

    override fun acceptNavigationParams(params: Any) {
        if (params is ZoneCreationMode) {
            Log.e("MapZoneCreationViewModel", "acceptNavigationParams: $params")
        }
    }

    override fun onEvent(event: MapZoneCreationEvent) {

    }
}