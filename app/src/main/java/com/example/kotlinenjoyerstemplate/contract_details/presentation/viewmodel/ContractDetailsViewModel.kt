package com.example.kotlinenjoyerstemplate.contract_details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinenjoyerstemplate.contract_details.ContractDetailsUiState
import com.example.kotlinenjoyerstemplate.contract_details.presentation.model.ContractDetailsItem
import com.example.kotlinenjoyerstemplate.core.data.ObjectRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContractDetailsViewModel(
    private val contractId: Long,
    private val objectRepository: ObjectRepository,
    private val factory: ContractDetailsFactory,
) : ViewModel() {

    private val _uiState: MutableStateFlow<ContractDetailsUiState> =
        MutableStateFlow(ContractDetailsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, _ ->
        _uiState.update { ContractDetailsUiState.Error }
    }

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO + handler) {
            val detailsResponse = objectRepository.getContractDetails(contractId, isMock = true)
            val detailsUi = factory.getContractDetailsUi(detailsResponse)
            val topBar = factory.getContractTopBar(detailsResponse)
            _uiState.update {
                ContractDetailsUiState.Content(
                    topBar = topBar,
                    model = detailsUi,
                )
            }
        }
    }

    fun onChooseStage(stage: ContractDetailsItem.Stages.Stage) {
        _uiState.update {
            val content = (_uiState.value as ContractDetailsUiState.Content)
            val stages = content.model
                .find { item ->
                    item is ContractDetailsItem.Stages
                } as ContractDetailsItem.Stages
            val newStages = stages.copy(chosenStage = stage)
            val newModel = (content.model - stages).toMutableList()
            newModel.add(index = 1, element = newStages)
            content.copy(model = newModel)
        }
    }
}