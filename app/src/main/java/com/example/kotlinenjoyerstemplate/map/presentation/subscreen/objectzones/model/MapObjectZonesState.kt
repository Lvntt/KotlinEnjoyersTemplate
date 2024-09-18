package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.model

import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.Zone

data class MapObjectZonesState(
    val zones: List<Zone> = emptyList(),
    val currentZoneMenuType: MapObjectZonesMenuType = MapObjectZonesMenuType.GENERAL,
)
