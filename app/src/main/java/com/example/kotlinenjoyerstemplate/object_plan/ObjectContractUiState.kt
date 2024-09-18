package com.example.kotlinenjoyerstemplate.object_plan

import com.example.kotlinenjoyerstemplate.object_plan.presentation.model.ObjectContractItem

sealed interface ObjectContractUiState {

    data object Loading : ObjectContractUiState

    data class Content(val model: List<ObjectContractItem>) : ObjectContractUiState
}