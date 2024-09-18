package com.example.kotlinenjoyerstemplate.map.presentation.subscreen

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

abstract class MapSubScreenViewModel<State, Event, Effect> {

    abstract val state: StateFlow<State>

    abstract val effects: SharedFlow<Effect>

    abstract fun onEvent(event: Event)

    abstract fun acceptNavigationParams(params: Any)

}