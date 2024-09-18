package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model

import com.mapbox.geojson.Point

sealed interface MapZoneCreationEvent {

    data object MenuOpenClicked : MapZoneCreationEvent

    data class PointAdded(val point: Point) : MapZoneCreationEvent

    data object RemoveLastPointClicked : MapZoneCreationEvent

    data object SaveZoneClicked : MapZoneCreationEvent

    data object CancelZoneCreationClicked : MapZoneCreationEvent

    data object BuildZone : MapZoneCreationEvent

}