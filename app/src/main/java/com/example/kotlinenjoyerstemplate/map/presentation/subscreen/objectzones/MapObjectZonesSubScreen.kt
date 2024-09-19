package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.ZoneRenderMode
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
import com.example.kotlinenjoyerstemplate.navigation.RootNavDestination
import com.example.kotlinenjoyerstemplate.ui.components.alert_dialog.HackathonAlertDialog
import com.example.kotlinenjoyerstemplate.ui.components.alert_dialog.model.HackathonAlertDialogButton
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButton
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors
import com.example.kotlinenjoyerstemplate.ui.components.button.model.HackathonButtonIcon
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme
import com.mapbox.maps.CameraState
import com.mapbox.maps.extension.compose.MapboxMapComposable
import com.mapbox.maps.extension.compose.MapboxMapScope
import com.mapbox.maps.extension.compose.annotation.generated.PolygonAnnotation
import com.mapbox.maps.extension.compose.annotation.generated.PolylineAnnotation

class MapObjectZonesSubScreen(private val store: MapSubScreenStore) :
    MapSubScreen<MapObjectZonesState, MapObjectZonesEvent, MapObjectZonesEffect> {

    override val viewModel = MapObjectZonesViewModel()

    override val isPartiallyExpandable: Boolean = false

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
    override suspend fun handleEffects(
        sheetState: BottomSheetScaffoldState,
        context: Context,
        navController: NavController,
    ) {
        viewModel.effects.collect { effect ->
            when (effect) {
                MapObjectZonesEffect.CloseBottomSheet -> sheetState.bottomSheetState.hide()
                MapObjectZonesEffect.OpenBottomSheet -> sheetState.bottomSheetState.show()
                is MapObjectZonesEffect.NavigateToZoneCreation -> store.navigateWithParams<MapZoneCreationSubScreen>(
                    effect.type
                )

                MapObjectZonesEffect.NavigateBack -> store.navigateBack()
                is MapObjectZonesEffect.Continue -> {
                    navController.navigate(RootNavDestination.ObjectCreation.getNavigationRoute(effect.arg))
                }

                MapObjectZonesEffect.ShowNoZonesError -> Toast.makeText(
                    context,
                    "Для продолжения укажите зоны",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }

    @Composable
    override fun BoxScope.MapControlsContent() {
        val state by viewModel.state.collectAsStateWithLifecycle()
        state.actionPromptZoneIndex?.let { _ ->
            HackathonAlertDialog(
                title = "Выберите действие",
                description = "Что вы хотите сделать с зоной?",
                confirmButton = HackathonAlertDialogButton(
                    text = "Удалить",
                    onClick = { viewModel.onEvent(MapObjectZonesEvent.ZoneDeleteClicked) },
                ),
                dismissButton = HackathonAlertDialogButton(
                    text = "Отмена",
                    onClick = { viewModel.onEvent(MapObjectZonesEvent.ZoneActionsDismissed) },
                ),
                onDismissRequest = { viewModel.onEvent(MapObjectZonesEvent.ZoneActionsDismissed) },
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp)
                .navigationBarsPadding(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            HackathonButton.M(
                onClick = {
                    viewModel.onEvent(MapObjectZonesEvent.MenuOpenClicked(MapObjectZonesMenuType.NEW_ZONE))
                },
                text = "Добавить зону",
                modifier = Modifier.shadow(2.dp, shape = RoundedCornerShape(12.dp)),
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.staticWhite,
                    contentColor = HackathonTheme.colors.common.staticBlack,
                ),
                icon = HackathonButtonIcon(
                    resId = R.drawable.ic_add_icon_24dp,
                    sizeDp = 24,
                    tintColor = HackathonTheme.colors.icons.primary,
                ),
                shape = RoundedCornerShape(12.dp),
            )
            HackathonButton.M(
                onClick = {
                    viewModel.onEvent(MapObjectZonesEvent.MenuOpenClicked(MapObjectZonesMenuType.GENERAL))
                },
                text = "Меню",
                modifier = Modifier.shadow(2.dp, shape = RoundedCornerShape(12.dp)),
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.staticWhite,
                    contentColor = HackathonTheme.colors.common.staticBlack,
                ),
                icon = HackathonButtonIcon(
                    resId = R.drawable.ic_menu_24dp,
                    sizeDp = 24,
                    tintColor = HackathonTheme.colors.icons.primary,
                ),
                shape = RoundedCornerShape(12.dp),
            )
        }
    }

    @Composable
    @MapboxMapComposable
    override fun MapboxMapScope.MapContent(cameraState: CameraState?) {
        val state by viewModel.state.collectAsStateWithLifecycle()
        val yellow = HackathonTheme.colors.elements.mapYellow
        val darkGray = HackathonTheme.colors.elements.darkGray

        state.zones.forEachIndexed { index, zone ->
            when (zone.renderMode) {
                ZoneRenderMode.POLYLINE -> PolylineAnnotation(
                    points = zone.points,
                    onClick = {
                        viewModel.onEvent(MapObjectZonesEvent.ZoneActionsClicked(index))
                        true
                    },
                ) {
                    lineColor = yellow
                    lineWidth = 5.0
                    lineBorderWidth = 1.0
                    lineBorderColor = darkGray
                }

                ZoneRenderMode.POLYGON -> PolygonAnnotation(
                    points = listOf(zone.points),
                    onClick = {
                        viewModel.onEvent(MapObjectZonesEvent.ZoneActionsClicked(index))
                        true
                    },
                ) {
                    fillColor = yellow
                    fillOutlineColor = darkGray
                }
            }
        }
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