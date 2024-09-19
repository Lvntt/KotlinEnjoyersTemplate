package com.example.kotlinenjoyerstemplate.map

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenStore
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme
import com.mapbox.geojson.Point
import com.mapbox.maps.Style
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.style.MapStyle
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    subScreenStore: MapSubScreenStore = koinViewModel(),
) {
    val currentSubScreen by subScreenStore.currentScreen.collectAsStateWithLifecycle()
    val density = LocalDensity.current
    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(
            skipPartiallyExpanded = !currentSubScreen.isPartiallyExpandable,
            density
        )
    )
    var sheetExpandedState by remember { mutableStateOf(SheetValue.Hidden) }
    val scope = rememberCoroutineScope()
    BackHandler {
        if (sheetExpandedState != SheetValue.Hidden) {
            scope.launch {
                sheetState.bottomSheetState.hide()
            }
        }
        else if (!subScreenStore.navigateBack()) {
            navController.popBackStack()
        }
    }

    val viewPortState = rememberMapViewportState {
        setCameraOptions {
            zoom(10.0)
            center(Point.fromLngLat(37.618423, 55.751244))
            pitch(45.0)
            bearing(0.0)
        }
    }
    val cameraState by remember { derivedStateOf { viewPortState.cameraState } }
    val context = LocalContext.current

    LaunchedEffect(currentSubScreen, sheetState) {
        currentSubScreen.handleEffects(sheetState, context, navController)
    }
    LaunchedEffect(currentSubScreen) {
        snapshotFlow { sheetState.bottomSheetState.currentValue }.collect { sheetValue ->
            currentSubScreen.onBottomSheetValue(sheetValue)
            sheetExpandedState = sheetValue
        }
    }

    BottomSheetScaffold(
        sheetContent = {
            with(currentSubScreen) { BottomSheetContent() }
        },
        scaffoldState = sheetState,
        sheetContainerColor = HackathonTheme.colors.background.grey,
        sheetPeekHeight = 250.dp,
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
                with(currentSubScreen) { MapContent(cameraState) }
            }
            AnimatedContent(
                targetState = currentSubScreen,
                label = "mapControlsAnimation",
                transitionSpec = {
                    fadeIn() togetherWith fadeOut()
                },
            ) { subScreen ->
                Box(modifier = Modifier.fillMaxSize()) {
                    with(subScreen) { MapControlsContent() }
                }
            }
        }
    }
}