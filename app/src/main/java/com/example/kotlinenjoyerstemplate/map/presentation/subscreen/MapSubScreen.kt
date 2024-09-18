package com.example.kotlinenjoyerstemplate.map.presentation.subscreen

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMapComposable
import com.mapbox.maps.extension.compose.MapboxMapScope

interface MapSubScreen<State, Event, Effect> {

    val viewModel: MapSubScreenViewModel<State, Event, Effect>

    fun onMapClick(point: Point) = Unit

    @OptIn(ExperimentalMaterial3Api::class)
    suspend fun handleEffects(sheetState: BottomSheetScaffoldState) = Unit

    @Composable
    fun ColumnScope.BottomSheetContent() = Unit

    @Composable
    @MapboxMapComposable
    fun MapboxMapScope.MapContent() = Unit

    @Composable
    fun BoxScope.MapControlsContent() = Unit

}