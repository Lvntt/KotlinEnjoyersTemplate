package com.example.kotlinenjoyerstemplate.map.data.repository

import com.example.kotlinenjoyerstemplate.map.data.model.ObjectSummary
import com.example.kotlinenjoyerstemplate.map.data.model.Point
import com.example.kotlinenjoyerstemplate.map.data.model.Zone
import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.ZoneRenderMode
import kotlinx.coroutines.delay

private val tempZone = ObjectSummary(
    1,
    listOf(50, 75, 0),
    listOf(
        Zone(
            listOf(
                Point(
                    latitude = 55.749182,
                    longitude = 37.60879,
                ),
                Point(
                    latitude = 55.748746,
                    longitude = 37.610391,
                ),
                Point(
                    latitude = 55.748593,
                    longitude = 37.61059,
                ),
                Point(
                    latitude = 55.746295,
                    longitude = 37.612409,
                )
            ),
            ZoneRenderMode.POLYLINE
        )
    )
)

class ObjectRepository {

    suspend fun getAllObjectSummaries() : List<ObjectSummary> {
        delay(5000)
        return listOf(tempZone)
    }

}