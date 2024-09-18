package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model

import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.Zone

sealed interface MapZoneCreationEffect {

    data object OpenBottomSheet : MapZoneCreationEffect

    data object CloseBottomSheet : MapZoneCreationEffect

    data object NavigateBack : MapZoneCreationEffect

    data class NavigateWithNewZone(val zone: Zone) : MapZoneCreationEffect

    data object ShowRouteError : MapZoneCreationEffect

    data object ShowNoZoneError : MapZoneCreationEffect

}