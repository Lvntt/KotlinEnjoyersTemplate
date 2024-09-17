package com.example.kotlinenjoyerstemplate.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.annotation.generated.PolylineAnnotation

@Composable
fun MapScreen(modifier: Modifier = Modifier) {
    val accentColor = HackathonTheme.colors.common.accent
    val viewPortState = rememberMapViewportState {
        setCameraOptions {
            zoom(2.0)
            center(Point.fromLngLat(-98.0, 39.5))
            pitch(0.0)
            bearing(0.0)
        }
    }
    var points by remember { mutableStateOf(listOf<Point>()) }

    MapboxMap(
        modifier.fillMaxSize(),
        mapViewportState = viewPortState,
        onMapClickListener = { point ->
            points = listOf(*points.toTypedArray() + point)
            true
        }
    ) {
        PolylineAnnotation(
            points = points
        ) {
            lineColor = accentColor
            lineWidth = 5.0
        }
    }
}