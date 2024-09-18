package com.example.kotlinenjoyerstemplate.map.presentation.model.zone.creation

import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.ZoneRenderMode

enum class ZoneCreationMode(pointMode: ZonePointCreationMode, renderMode: ZoneRenderMode) {
    POLYLINE(ZonePointCreationMode.USER_DEFINED, ZoneRenderMode.POLYLINE),
    POLYGON(ZonePointCreationMode.USER_DEFINED, ZoneRenderMode.POLYGON),
    ROUTE(ZonePointCreationMode.ROUTE_BASED, ZoneRenderMode.POLYLINE),
}