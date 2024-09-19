package com.example.kotlinenjoyerstemplate.map.presentation.subscreen

import android.content.Context
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.runtime.Composable
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraState
import com.mapbox.maps.extension.compose.MapboxMapComposable
import com.mapbox.maps.extension.compose.MapboxMapScope

interface MapSubScreen<State, Event, Effect> {

    val viewModel: MapSubScreenViewModel<State, Event, Effect>

    fun onMapClick(point: Point) = Unit

    @OptIn(ExperimentalMaterial3Api::class)
    suspend fun handleEffects(sheetState: BottomSheetScaffoldState, context: Context) = Unit

    @OptIn(ExperimentalMaterial3Api::class)
    suspend fun onBottomSheetValue(sheetValue: SheetValue) = Unit

    @Composable
    fun ColumnScope.BottomSheetContent() = Unit

    @Composable
    @MapboxMapComposable
    fun MapboxMapScope.MapContent(cameraState: CameraState?) = Unit

    @Composable
    fun BoxScope.MapControlsContent() = Unit

}