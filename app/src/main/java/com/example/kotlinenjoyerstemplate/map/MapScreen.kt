package com.example.kotlinenjoyerstemplate.map

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenStore
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme
import com.mapbox.geojson.Point
import com.mapbox.maps.Style
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.style.MapStyle
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    subScreenStore: MapSubScreenStore = koinViewModel(),
) {
    BackHandler {
        if (!subScreenStore.navigateBack()) {
            navController.popBackStack()
        }
    }

    val currentSubScreen by subScreenStore.currentScreen.collectAsStateWithLifecycle()
    val viewPortState = rememberMapViewportState {
        setCameraOptions {
            zoom(10.0)
            center(Point.fromLngLat(37.618423, 55.751244))
            pitch(45.0)
            bearing(0.0)
        }
    }
    val density = LocalDensity.current
    val context = LocalContext.current
    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(
            skipPartiallyExpanded = true,
            density
        )
    )

    LaunchedEffect(currentSubScreen, sheetState) {
        currentSubScreen.handleEffects(sheetState, context)
    }

    BottomSheetScaffold(
        sheetContent = {
            with(currentSubScreen) { BottomSheetContent() }
        },
        scaffoldState = sheetState,
        sheetContainerColor = HackathonTheme.colors.background.grey,
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            MapboxMap(
                modifier.fillMaxSize(),
                mapViewportState = viewPortState,
                onMapClickListener = { point ->
                    currentSubScreen.onMapClick(point)
                    true
                },
                style = {
                    MapStyle(style = Style.STANDARD)
                },
            ) {
                with(currentSubScreen) { MapContent() }
            }
            with(currentSubScreen) { MapControlsContent() }
        }
    }
}