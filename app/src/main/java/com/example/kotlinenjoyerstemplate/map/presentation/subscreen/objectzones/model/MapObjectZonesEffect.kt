package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.model

import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.creation.ZoneCreationMode

sealed interface MapObjectZonesEffect {

    data object OpenBottomSheet : MapObjectZonesEffect

    data object CloseBottomSheet : MapObjectZonesEffect

    data class NavigateToZoneCreation(val type: ZoneCreationMode) : MapObjectZonesEffect

}