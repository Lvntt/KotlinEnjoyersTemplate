package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model

import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.creation.ZoneCreationMode
import com.mapbox.geojson.Point

data class MapZoneCreationState(
    val mode: ZoneCreationMode = ZoneCreationMode.POLYLINE,
    val points: List<Point> = emptyList(),
    val zonePoints: List<Point> = emptyList(),
)