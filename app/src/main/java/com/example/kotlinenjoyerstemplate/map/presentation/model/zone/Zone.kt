package com.example.kotlinenjoyerstemplate.map.presentation.model.zone

import com.mapbox.geojson.Point

data class Zone(
    val points: List<Point>,
    val renderMode: ZoneRenderMode
)
