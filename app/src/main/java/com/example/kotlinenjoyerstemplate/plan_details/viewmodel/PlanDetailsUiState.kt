package com.example.kotlinenjoyerstemplate.plan_details.viewmodel

import com.example.kotlinenjoyerstemplate.plan_details.model.PlanDetailsItem

sealed interface PlanDetailsUiState {

    data object Loading : PlanDetailsUiState

    data class Content(
        val topBar: PlanDetailsItem.TopBar,
        val model: List<PlanDetailsItem>,
    ) : PlanDetailsUiState

    data object Error : PlanDetailsUiState
}