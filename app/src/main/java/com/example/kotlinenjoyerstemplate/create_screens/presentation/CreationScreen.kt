package com.example.kotlinenjoyerstemplate.create_screens.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.kotlinenjoyerstemplate.Marker
import com.example.kotlinenjoyerstemplate.create_screens.presentation.create_object.CreateObjectScreen
import com.example.kotlinenjoyerstemplate.create_screens.presentation.create_plan.CreatePlanScreen
import com.example.kotlinenjoyerstemplate.create_screens.presentation.model.ObjectCreationEffect
import com.example.kotlinenjoyerstemplate.create_screens.presentation.model.ObjectCreationEvent

@Composable
fun CreationScreen(
    viewModel: CreationViewModel,
    navController: NavController,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    BackHandler {
        if (state.currentPlanIndex != null) {
            viewModel.onEvent(ObjectCreationEvent.BackClicked)
        } else {
            Marker.markerFlow.value = null
            navController.popBackStack()
        }
    }

    LaunchedEffect(Unit) {
        viewModel.effects.collect { effect ->
            when (effect) {
                ObjectCreationEffect.CloseScreen -> {
                    Marker.markerFlow.value = false
                    navController.popBackStack()
                }

                ObjectCreationEffect.SaveObject -> {
                    Marker.markerFlow.value = true
                    navController.popBackStack()
                }

                ObjectCreationEffect.NavigateBack -> {
                    Marker.markerFlow.value = null
                    navController.popBackStack()
                }
            }
        }
    }

    Crossfade(state.currentPlanIndex, label = "") {
        if (it == null) {
            CreateObjectScreen(state) { viewModel.onEvent(it) }
        } else {
            CreatePlanScreen(state) { viewModel.onEvent(it) }
        }
    }
}