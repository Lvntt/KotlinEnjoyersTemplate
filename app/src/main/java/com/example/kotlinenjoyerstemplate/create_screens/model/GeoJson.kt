package com.example.kotlinenjoyerstemplate.create_screens.model

import com.example.kotlinenjoyerstemplate.map.data.model.Zone

data class GeoJson(
    val name: String = "",
    val zones: List<Zone>,
)
