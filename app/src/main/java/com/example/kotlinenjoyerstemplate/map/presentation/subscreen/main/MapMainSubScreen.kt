package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastForEachIndexed
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.company_list.compose.CompanyList
import com.example.kotlinenjoyerstemplate.map.presentation.model.zone.ZoneRenderMode
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreen
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenStore
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.components.ObjectMarker
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.components.ObjectMarkerPlaceholder
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.components.SearchTextField
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainEffect
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainEvent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainState
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.MapObjectZonesSubScreen
import com.example.kotlinenjoyerstemplate.navigation.ObjectDetailsNavigation
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButton
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors
import com.example.kotlinenjoyerstemplate.ui.components.button.model.HackathonButtonIcon
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme
import com.mapbox.maps.CameraState
import com.mapbox.maps.extension.compose.MapboxMapComposable
import com.mapbox.maps.extension.compose.MapboxMapScope
import com.mapbox.maps.extension.compose.annotation.ViewAnnotation
import com.mapbox.maps.extension.compose.annotation.generated.PolygonAnnotation
import com.mapbox.maps.extension.compose.annotation.generated.PolylineAnnotation
import com.mapbox.maps.viewannotation.geometry
import com.mapbox.maps.viewannotation.viewAnnotationOptions

class MapMainSubScreen(
    private val store: MapSubScreenStore,
    override val viewModel: MapMainViewModel,
) :
    MapSubScreen<MapMainState, MapMainEvent, MapMainEffect> {

    override val isPartiallyExpandable: Boolean = true

    @OptIn(ExperimentalMaterial3Api::class)
    override suspend fun handleEffects(
        sheetState: BottomSheetScaffoldState,
        context: Context,
        navController: NavController,
    ) {
        viewModel.effects.collect { effect ->
            when (effect) {
                MapMainEffect.NavigateToNewObject -> store.navigateWithParams<MapObjectZonesSubScreen>(
                    Unit
                )

                MapMainEffect.OpenBottomSheet -> sheetState.bottomSheetState.show()
                MapMainEffect.ShowLoadingError -> Toast.makeText(
                    context,
                    "Не удалось загрузить информацию об объектах",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override suspend fun onBottomSheetValue(sheetValue: SheetValue) {
        if (sheetValue == SheetValue.Hidden) {
            viewModel.onEvent(MapMainEvent.ObjectUnselected)
        }
    }

    @Composable
    override fun BoxScope.MapControlsContent() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .statusBarsPadding(),
            contentAlignment = Alignment.TopCenter
        ) {
            SearchTextField(
                text = "",
                onTextChanged = {},
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp)
                .navigationBarsPadding(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            HackathonButton.M(
                onClick = {
                    viewModel.onEvent(MapMainEvent.AddNewObjectClicked)
                },
                text = "Добавить объект",
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
                    viewModel.onEvent(MapMainEvent.BottomSheetOpened)
                },
                text = "Список компаний",
                modifier = Modifier.shadow(2.dp, shape = RoundedCornerShape(12.dp)),
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.staticWhite,
                    contentColor = HackathonTheme.colors.common.staticBlack,
                ),
                icon = HackathonButtonIcon(
                    resId = R.drawable.ic_list_24dp,
                    sizeDp = 24,
                    tintColor = HackathonTheme.colors.icons.primary,
                ),
                shape = RoundedCornerShape(12.dp),
            )
        }
    }

    @Composable
    override fun ColumnScope.BottomSheetContent() {
        val state by viewModel.state.collectAsStateWithLifecycle()

        state.selectedObjectInfoIndex?.let { index ->
            val objectId = state.objectInfos[index].id
            val navController = rememberNavController()
            ObjectDetailsNavigation(navController, objectId)
        } ?: CompanyList()
    }

    @Composable
    @MapboxMapComposable
    override fun MapboxMapScope.MapContent(cameraState: CameraState?) {
        val state by viewModel.state.collectAsStateWithLifecycle()
        val yellow = HackathonTheme.colors.elements.mapYellow
        val accent = HackathonTheme.colors.common.accent
        val darkGray = HackathonTheme.colors.elements.darkGray

        state.objectInfos.fastForEachIndexed { index, objectInfo ->
            val color = if (index == state.selectedObjectInfoIndex) accent else yellow

            objectInfo.zones.fastForEach { zone ->
                when (zone.renderMode) {
                    ZoneRenderMode.POLYLINE -> PolylineAnnotation(
                        points = zone.points,
                    ) {
                        lineColor = color
                        lineWidth = 5.0
                        lineBorderWidth = 1.0
                        lineBorderColor = darkGray
                    }

                    ZoneRenderMode.POLYGON -> PolygonAnnotation(
                        points = listOf(zone.points),
                    ) {
                        fillColor = color
                        fillOutlineColor = darkGray
                    }
                }
            }

            if ((cameraState?.zoom ?: 0.0) >= 15.0) {
                ViewAnnotation(
                    options = viewAnnotationOptions {
                        geometry(objectInfo.viewPoint)
                    },
                ) {
                    if (objectInfo.planProgressions.isNotEmpty()) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            objectInfo.planProgressions.fastForEach { progress ->
                                ObjectMarker(progress = progress, modifier = Modifier.clickable {
                                    viewModel.onEvent(
                                        MapMainEvent.ObjectClicked(index)
                                    )
                                })
                            }
                        }
                    } else {
                        ObjectMarkerPlaceholder(modifier = Modifier.clickable {
                            viewModel.onEvent(
                                MapMainEvent.ObjectClicked(index)
                            )
                        })
                    }
                }
            }
        }
    }
}