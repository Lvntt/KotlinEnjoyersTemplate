package com.example.kotlinenjoyerstemplate.plan_details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinenjoyerstemplate.core.data.ObjectRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlanDetailsViewModel(
    private val planId: Long,
    private val objectRepository: ObjectRepository,
    private val factory: PlanDetailsFactory,
) : ViewModel() {

    private val _uiState: MutableStateFlow<PlanDetailsUiState> = MutableStateFlow(PlanDetailsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, _ ->
        _uiState.update { PlanDetailsUiState.Error }
    }

    init {
        loadData()
    }

    fun loadData() {
        _uiState.update { PlanDetailsUiState.Loading }
        viewModelScope.launch(Dispatchers.IO + handler) {
            val detailsResponse = objectRepository.getPlanDetails(planId, isMock = true)
            val detailsUi = factory.getPlanDetailsUi(detailsResponse)
            val topBar = factory.getPlanDetailsTopBar(detailsResponse)
            _uiState.update {
                PlanDetailsUiState.Content(
                    topBar = topBar,
                    model = detailsUi,
                )
            }
        }
    }
}