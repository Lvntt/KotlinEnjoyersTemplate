package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main

import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenViewModel
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainEffect
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainEvent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class MapMainViewModel : MapSubScreenViewModel<MapMainState, MapMainEvent, MapMainEffect>() {
    private val _state = MutableStateFlow(MapMainState())
    override val state = _state.asStateFlow()

    private val _effects = MutableSharedFlow<MapMainEffect>(extraBufferCapacity = 1)
    override val effects = _effects.asSharedFlow()

    override fun acceptNavigationParams(params: Any) {}

    override fun onEvent(event: MapMainEvent) {
        when (event) {
            MapMainEvent.AddNewObjectClicked -> {
                _effects.tryEmit(MapMainEffect.NavigateToNewObject)
            }
        }
    }

}