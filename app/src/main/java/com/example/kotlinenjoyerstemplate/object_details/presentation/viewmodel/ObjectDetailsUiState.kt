package com.example.kotlinenjoyerstemplate.object_details.presentation.viewmodel

import com.example.kotlinenjoyerstemplate.object_details.presentation.model.ObjectDetailsItem

sealed interface ObjectDetailsUiState {

    data object Loading : ObjectDetailsUiState

    data class Content(val model: List<ObjectDetailsItem>) : ObjectDetailsUiState

    data object Error : ObjectDetailsUiState
}