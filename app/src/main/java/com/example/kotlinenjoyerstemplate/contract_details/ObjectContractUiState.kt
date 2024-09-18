package com.example.kotlinenjoyerstemplate.contract_details

import com.example.kotlinenjoyerstemplate.contract_details.presentation.model.ObjectContractItem

sealed interface ObjectContractUiState {

    data object Loading : ObjectContractUiState

    data class Content(val model: List<ObjectContractItem>) : ObjectContractUiState
}