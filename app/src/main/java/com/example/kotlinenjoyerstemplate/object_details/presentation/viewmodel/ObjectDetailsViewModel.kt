package com.example.kotlinenjoyerstemplate.object_details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinenjoyerstemplate.core.data.ObjectRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ObjectDetailsViewModel(
    private val objectId: Long,
    private val objectRepository: ObjectRepository,
    private val factory: ObjectDetailsFactory,
) : ViewModel() {

    private val _uiState: MutableStateFlow<ObjectDetailsUiState> = MutableStateFlow(ObjectDetailsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, _ ->
        _uiState.update { ObjectDetailsUiState.Error }
    }

    init {
        loadData()
    }

    fun loadData() {
        _uiState.update { ObjectDetailsUiState.Loading }
        viewModelScope.launch(Dispatchers.IO + handler) {
            val detailsResponse = objectRepository.getObjectDetails(objectId)
            val detailsUi = factory.getObjectDetailsUi(detailsResponse)
            _uiState.update {
                ObjectDetailsUiState.Content(model = detailsUi)
            }
        }
    }
}