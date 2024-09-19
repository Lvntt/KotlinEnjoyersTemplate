package com.example.kotlinenjoyerstemplate.map.data.model

import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.ZoneRenderMode

data class Zone(
    val points: List<Point>,
    val renderMode: ZoneRenderMode
)