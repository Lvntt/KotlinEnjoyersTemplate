package com.example.kotlinenjoyerstemplate.map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme
import com.mapbox.api.directions.v5.models.RouteOptions
import com.mapbox.geojson.Point
import com.mapbox.maps.Style
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.annotation.generated.PointAnnotation
import com.mapbox.maps.extension.compose.annotation.generated.PolylineAnnotation
import com.mapbox.maps.extension.compose.annotation.rememberIconImage
import com.mapbox.maps.extension.compose.style.MapStyle
import com.mapbox.navigation.base.extensions.applyDefaultNavigationOptions
import com.mapbox.navigation.base.route.NavigationRoute
import com.mapbox.navigation.base.route.NavigationRouterCallback
import com.mapbox.navigation.base.route.RouterFailure
import com.mapbox.navigation.core.lifecycle.MapboxNavigationApp

@Composable
fun MapScreen(modifier: Modifier = Modifier) {
    val accentColor = HackathonTheme.colors.common.accent
    val viewPortState = rememberMapViewportState {
        setCameraOptions {
            zoom(2.0)
            center(Point.fromLngLat(-98.0, 39.5))
            pitch(45.0)
            bearing(0.0)
        }
    }
    val marker =
        rememberIconImage(key = null, painter = painterResource(R.drawable.ic_map_point_24dp))
    var points by remember { mutableStateOf(listOf<Point>()) }
    var routePoints by remember { mutableStateOf<List<Point>?>(null) }
    var buildRouteMarker by remember { mutableStateOf(false) }

    LaunchedEffect(buildRouteMarker) {
        if (points.size < 2) return@LaunchedEffect
        MapboxNavigationApp.current()
            ?.requestRoutes(RouteOptions.builder().applyDefaultNavigationOptions()
                .coordinatesList(points).build(),
                object : NavigationRouterCallback {
                    override fun onCanceled(routeOptions: RouteOptions, routerOrigin: String) {}

                    override fun onFailure(
                        reasons: List<RouterFailure>,
                        routeOptions: RouteOptions,
                    ) {
                        //TODO display error
                    }

                    override fun onRoutesReady(
                        routes: List<NavigationRoute>,
                        routerOrigin: String,
                    ) {
                        routePoints =
                            routes.firstOrNull()?.directionsRoute?.geometry()?.decodePolyline()
                    }
                })
    }

    Box(modifier = Modifier.fillMaxSize()) {
        MapboxMap(
            modifier.fillMaxSize(),
            mapViewportState = viewPortState,
            onMapClickListener = { point ->
                points = listOf(*points.toTypedArray() + point)
                true
            },
            style = {
                MapStyle(style = Style.DARK)
            },
        ) {
            routePoints?.let { route ->
                PolylineAnnotation(
                    points = route,
                ) {
                    lineColor = accentColor
                    lineWidth = 5.0
                }
            }
            points.forEach { point ->
                PointAnnotation(
                    point = point,
                ) {
                    iconImage = marker
                }
            }
        }
        Button(
            onClick = {
                buildRouteMarker = !buildRouteMarker
            },
            modifier = Modifier.align(Alignment.BottomCenter),
        ) {
            //TODO display progress
            Text(text = "Build route")
        }
    }
}