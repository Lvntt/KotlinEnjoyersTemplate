package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.ZoneRenderMode
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreen
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenStore
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.bottomsheet.BottomSheetItem
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.bottomsheet.GenericBottomSheetContent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model.MapZoneCreationEffect
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model.MapZoneCreationEvent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.zonecreation.model.MapZoneCreationState
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButton
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMapComposable
import com.mapbox.maps.extension.compose.MapboxMapScope
import com.mapbox.maps.extension.compose.annotation.generated.PointAnnotation
import com.mapbox.maps.extension.compose.annotation.generated.PolygonAnnotation
import com.mapbox.maps.extension.compose.annotation.generated.PolylineAnnotation
import com.mapbox.maps.extension.compose.annotation.rememberIconImage

class MapZoneCreationSubScreen(
    private val store: MapSubScreenStore,
    override val viewModel: MapZoneCreationViewModel,
) : MapSubScreen<MapZoneCreationState, MapZoneCreationEvent, MapZoneCreationEffect> {

    private val sheetItems = listOf(
        BottomSheetItem(
            iconResId = R.drawable.ic_route_24dp,
            title = "Построить маршрут",
            onClick = { viewModel.onEvent(MapZoneCreationEvent.BuildZone) },
        ),
        BottomSheetItem(
            iconResId = R.drawable.ic_tick_24dp,
            title = "Сохранить зону",
            onClick = { viewModel.onEvent(MapZoneCreationEvent.SaveZoneClicked) },
        ),
        BottomSheetItem(
            iconResId = R.drawable.ic_close_24dp,
            title = "Отменить создание зоны",
            onClick = { viewModel.onEvent(MapZoneCreationEvent.CancelZoneCreationClicked) },
        ),
    )

    override val isPartiallyExpandable: Boolean = false

    override fun onMapClick(point: Point) {
        viewModel.onEvent(MapZoneCreationEvent.PointAdded(point))
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override suspend fun handleEffects(sheetState: BottomSheetScaffoldState, context: Context) {
        viewModel.effects.collect { effect ->
            when (effect) {
                MapZoneCreationEffect.CloseBottomSheet -> sheetState.bottomSheetState.hide()

                MapZoneCreationEffect.NavigateBack -> store.navigateBack()

                is MapZoneCreationEffect.NavigateWithNewZone -> store.navigateBackWithParams(
                    effect.zone,
                )
                MapZoneCreationEffect.OpenBottomSheet -> sheetState.bottomSheetState.show()

                MapZoneCreationEffect.ShowRouteError -> Toast.makeText(
                    context,
                    "Ошибка при построении маршрута",
                    Toast.LENGTH_SHORT,
                ).show()

                MapZoneCreationEffect.ShowNoZoneError -> Toast.makeText(
                    context,
                    "Зона не создана",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
    }

    @Composable
    override fun ColumnScope.BottomSheetContent() {
        GenericBottomSheetContent(
            title = "Меню",
            items = sheetItems,
        )
    }

    @Composable
    @MapboxMapComposable
    override fun MapboxMapScope.MapContent() {
        val state by viewModel.state.collectAsStateWithLifecycle()
        val marker =
            rememberIconImage(key = null, painter = painterResource(R.drawable.ic_map_point_48dp))
        val yellow = HackathonTheme.colors.elements.mapYellow
        val darkGray = HackathonTheme.colors.elements.darkGray

        state.points.forEach { point ->
            PointAnnotation(
                point = point
            ) {
                iconImage = marker
            }
        }
        when (state.mode.renderMode) {
            ZoneRenderMode.POLYLINE -> PolylineAnnotation(
                points = state.zonePoints
            ) {
                lineColor = yellow
                lineWidth = 5.0
                lineBorderWidth = 1.0
                lineBorderColor = darkGray
            }

            ZoneRenderMode.POLYGON -> PolygonAnnotation(
                points = listOf(state.zonePoints)
            ) {
                fillColor = yellow
                fillOutlineColor = darkGray
            }
        }
    }

    @Composable
    override fun BoxScope.MapControlsContent() {
        Row(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        listOf(
                            HackathonTheme.colors.common.staticBlack.copy(alpha = 0.5f),
                            Color.Transparent
                        )
                    )
                )
                .padding(bottom = 130.dp, top = 12.dp, start = 12.dp, end = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_info_24dp),
                contentDescription = null,
                modifier = Modifier.size(36.dp),
                tint = HackathonTheme.colors.common.staticWhite,
            )
            Text(
                text = "Нажмите на место на карте, чтобы добавить точку",
                color = HackathonTheme.colors.common.staticWhite,
                style = HackathonTheme.typography.titles.titleXL,
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            HackathonButton.S(
                onClick = {
                    viewModel.onEvent(MapZoneCreationEvent.RemoveLastPointClicked)
                },
                text = "Удалить последнюю точку",
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.accent,
                    contentColor = HackathonTheme.colors.common.staticWhite,
                ),
            )
            HackathonButton.S(
                onClick = {
                    viewModel.onEvent(MapZoneCreationEvent.MenuOpenClicked)
                },
                text = "Меню",
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.accent,
                    contentColor = HackathonTheme.colors.common.staticWhite,
                ),
            )
        }
    }
}