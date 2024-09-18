package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation

import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreen
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenStore
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model.MapZoneCreationEffect
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model.MapZoneCreationEvent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model.MapZoneCreationState

class MapZoneCreationSubScreen(private val store: MapSubScreenStore) :
    MapSubScreen<MapZoneCreationState,MapZoneCreationEvent, MapZoneCreationEffect> {

    override val viewModel = MapZoneCreationViewModel()

}