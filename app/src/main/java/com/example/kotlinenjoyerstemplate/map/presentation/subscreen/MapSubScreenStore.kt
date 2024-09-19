package com.example.kotlinenjoyerstemplate.map.presentation.subscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinenjoyerstemplate.map.data.repository.ObjectRepository
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.MapMainSubScreen
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.MapMainViewModel
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.MapObjectZonesSubScreen
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.MapZoneCreationSubScreen
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.MapZoneCreationViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.java.KoinJavaComponent.inject

class MapSubScreenStore : ViewModel() {

    private val objectRepo: ObjectRepository by inject(ObjectRepository::class.java)

    val screens = listOf(
        MapMainSubScreen(this, MapMainViewModel(objectRepo, viewModelScope)),
        MapObjectZonesSubScreen(this, viewModelScope),
        MapZoneCreationSubScreen(this, MapZoneCreationViewModel(viewModelScope))
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

    fun navigateBackWithParams(params: Any) : Boolean {
        if (backStack.size == 1) return false
        backStack.removeLast()
        val screen = backStack.last()
        screen.viewModel.acceptNavigationParams(params)
        currentScreen.value = screen
        return true
    }
}