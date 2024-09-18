package com.example.kotlinenjoyerstemplate.map.presentation.subscreen

import androidx.lifecycle.ViewModel
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.MapObjectZonesSubScreen
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.MapZoneCreationSubScreen
import kotlinx.coroutines.flow.MutableStateFlow

class MapSubScreenStore : ViewModel() {

    val screens = listOf(
        MapObjectZonesSubScreen(this),
        MapZoneCreationSubScreen(this)
    )

    val currentScreen = MutableStateFlow<MapSubScreen<*, *, *>>(screens.first())

    val backStack = ArrayDeque<MapSubScreen<*, *, *>>(listOf(screens.first()))

    inline fun <reified T : MapSubScreen<*, *, *>> navigateWithParams(params: Any) {
        val screen = screens.first { it is T }
        screen.viewModel.acceptNavigationParams(params)
        currentScreen.value = screen
        backStack.add(screen)
    }

    fun navigateBack() : Boolean {
        if (backStack.size == 1) return false
        backStack.removeLast()
        currentScreen.value = backStack.last()
        return true
    }
}