package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model

import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.Zone
import com.mapbox.geojson.Point

data class ObjectInfo(
    val id: Long,
    val planProgressions: List<Int>,
    val viewPoint: Point,
    val zones: List<Zone>,
)
