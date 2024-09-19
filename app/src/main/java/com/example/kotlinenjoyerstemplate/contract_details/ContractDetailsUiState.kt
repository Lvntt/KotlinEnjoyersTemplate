package com.example.kotlinenjoyerstemplate.contract_details

import com.example.kotlinenjoyerstemplate.contract_details.presentation.model.ContractDetailsItem

sealed interface ContractDetailsUiState {

    data object Loading : ContractDetailsUiState

    data class Content(
        val model: List<ContractDetailsItem>,
        val topBar: ContractDetailsItem.TopBar,
    ) : ContractDetailsUiState

    data object Error : ContractDetailsUiState
}