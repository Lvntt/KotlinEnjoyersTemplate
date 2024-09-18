package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.model

import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.creation.ZoneCreationMode

sealed interface MapObjectZonesEvent {

    data class MenuOpenClicked(val menuType: MapObjectZonesMenuType) : MapObjectZonesEvent

    data class CreateZoneClicked(val mode: ZoneCreationMode) : MapObjectZonesEvent

    data object ContinueClicked : MapObjectZonesEvent

    data object CancelClicked : MapObjectZonesEvent

    data class ZoneActionsClicked(val zoneIndex: Int) : MapObjectZonesEvent

    data object ZoneActionsDismissed : MapObjectZonesEvent

    data object ZoneDeleteClicked : MapObjectZonesEvent

}