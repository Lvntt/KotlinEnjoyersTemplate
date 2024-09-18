package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.creation.ZoneCreationMode
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreen
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenStore
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.bottomsheet.BottomSheetItem
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.bottomsheet.GenericBottomSheetContent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.model.MapObjectZonesEffect
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.model.MapObjectZonesEvent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.model.MapObjectZonesMenuType
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.model.MapObjectZonesState
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.MapZoneCreationSubScreen
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButton
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme
import com.mapbox.maps.extension.compose.MapboxMapComposable
import com.mapbox.maps.extension.compose.MapboxMapScope

class MapObjectZonesSubScreen(private val store: MapSubScreenStore) :
    MapSubScreen<MapObjectZonesState, MapObjectZonesEvent, MapObjectZonesEffect> {

    override val viewModel = MapObjectZonesViewModel()

    private val menuSheetItems = listOf(
        BottomSheetItem(
            iconResId = R.drawable.ic_arrow_right_24dp,
            title = "Продолжить",
            onClick = { viewModel.onEvent(MapObjectZonesEvent.ContinueClicked) },
        ),
        BottomSheetItem(
            iconResId = R.drawable.ic_close_24dp,
            title = "Отмена",
            onClick = { viewModel.onEvent(MapObjectZonesEvent.CancelClicked) },
        ),
    )

    private val newZoneSheetItems = listOf(
        BottomSheetItem(
            iconResId = R.drawable.ic_route_24dp,
            title = "Маршрут",
            onClick = { viewModel.onEvent(MapObjectZonesEvent.CreateZoneClicked(ZoneCreationMode.ROUTE)) },
        ),
        BottomSheetItem(
            iconResId = R.drawable.ic_polyline_24dp,
            title = "Ломаная линия",
            onClick = { viewModel.onEvent(MapObjectZonesEvent.CreateZoneClicked(ZoneCreationMode.POLYLINE)) },
        ),
        BottomSheetItem(
            iconResId = R.drawable.ic_polygon_24dp,
            title = "Полигон",
            onClick = { viewModel.onEvent(MapObjectZonesEvent.CreateZoneClicked(ZoneCreationMode.POLYGON)) },
        ),
    )

    @OptIn(ExperimentalMaterial3Api::class)
    override suspend fun handleEffects(sheetState: BottomSheetScaffoldState) {
        viewModel.effects.collect { effect ->
            when (effect) {
                MapObjectZonesEffect.CloseBottomSheet -> sheetState.bottomSheetState.hide()
                MapObjectZonesEffect.OpenBottomSheet -> sheetState.bottomSheetState.show()
                is MapObjectZonesEffect.NavigateToZoneCreation -> store.navigateWithParams<MapZoneCreationSubScreen>(
                    effect.type
                )
            }
        }
    }

    @Composable
    override fun BoxScope.MapControlsContent() {
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            HackathonButton.S(
                onClick = {
                    viewModel.onEvent(MapObjectZonesEvent.MenuOpenClicked(MapObjectZonesMenuType.NEW_ZONE))
                },
                text = "Добавить зону",
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.accent,
                    contentColor = HackathonTheme.colors.common.staticWhite,
                ),
            )
            HackathonButton.S(
                onClick = {
                    viewModel.onEvent(MapObjectZonesEvent.MenuOpenClicked(MapObjectZonesMenuType.GENERAL))
                },
                text = "Меню",
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.accent,
                    contentColor = HackathonTheme.colors.common.staticWhite,
                ),
            )
        }
    }

    @Composable
    @MapboxMapComposable
    override fun MapboxMapScope.MapContent() {
    }

    @Composable
    override fun ColumnScope.BottomSheetContent() {
        val state by viewModel.state.collectAsStateWithLifecycle()
        GenericBottomSheetContent(
            title = when (state.currentZoneMenuType) {
                MapObjectZonesMenuType.GENERAL -> "Меню создания объекта работы"
                MapObjectZonesMenuType.NEW_ZONE -> "Меню"
            },
            items = when (state.currentZoneMenuType) {
                MapObjectZonesMenuType.GENERAL -> menuSheetItems
                MapObjectZonesMenuType.NEW_ZONE -> newZoneSheetItems
            },
        )
    }
}