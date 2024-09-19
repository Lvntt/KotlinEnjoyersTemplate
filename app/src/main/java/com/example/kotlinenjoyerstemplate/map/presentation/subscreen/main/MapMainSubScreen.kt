package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreen
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenStore
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.components.SearchTextField
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainEffect
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainEvent
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model.MapMainState
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.objectzones.MapObjectZonesSubScreen
import com.example.kotlinenjoyerstemplate.navigation.ObjectDetailsNavigation
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButton
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

class MapMainSubScreen(private val store: MapSubScreenStore) :
    MapSubScreen<MapMainState, MapMainEvent, MapMainEffect> {

    override val viewModel = MapMainViewModel()

    override val isPartiallyExpandable: Boolean = true

    @OptIn(ExperimentalMaterial3Api::class)
    override suspend fun handleEffects(sheetState: BottomSheetScaffoldState, context: Context) {
        viewModel.effects.collect { effect ->
            when (effect) {
                MapMainEffect.NavigateToNewObject -> store.navigateWithParams<MapObjectZonesSubScreen>(Unit)
                MapMainEffect.OpenBottomSheet -> sheetState.bottomSheetState.show()
            }
        }
    }

    @Composable
    override fun BoxScope.MapControlsContent() {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            contentAlignment = Alignment.TopCenter) {
            SearchTextField(
                text = "",
                onTextChanged = {},
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
                    viewModel.onEvent(MapMainEvent.AddNewObjectClicked)
                },
                text = "Добавить объект",
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.accent,
                    contentColor = HackathonTheme.colors.common.staticWhite,
                ),
            )
            HackathonButton.S(
                onClick = {
                    viewModel.onEvent(MapMainEvent.ObjectClicked("id"))
                },
                text = "Чзх bottom sheet????",
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.accent,
                    contentColor = HackathonTheme.colors.common.staticWhite,
                ),
            )
        }
    }

    @Composable
    override fun ColumnScope.BottomSheetContent() {
        val state by viewModel.state.collectAsStateWithLifecycle()

        val navController = rememberNavController()
        ObjectDetailsNavigation(navController)
    }
}