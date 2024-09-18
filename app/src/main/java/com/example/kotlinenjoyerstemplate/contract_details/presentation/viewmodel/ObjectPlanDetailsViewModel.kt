package com.example.kotlinenjoyerstemplate.contract_details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinenjoyerstemplate.contract_details.ObjectContractUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ObjectPlanDetailsViewModel(
    private val planId: String,
) : ViewModel() {

    private val _uiState: MutableStateFlow<ObjectContractUiState> = MutableStateFlow(ObjectContractUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {

    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}