package com.example.kotlinenjoyerstemplate.create_screens.presentation

import androidx.lifecycle.ViewModel
import com.example.kotlinenjoyerstemplate.create_screens.model.GeoJson
import com.example.kotlinenjoyerstemplate.create_screens.presentation.model.ObjectCreationState
import com.example.kotlinenjoyerstemplate.create_screens.model.ObjectModel
import com.example.kotlinenjoyerstemplate.create_screens.model.PlanModel
import com.example.kotlinenjoyerstemplate.create_screens.presentation.model.ObjectCreationEffect
import com.example.kotlinenjoyerstemplate.create_screens.presentation.model.ObjectCreationEvent
import com.example.kotlinenjoyerstemplate.map.data.model.Zone
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CreationViewModel(
    zones: List<Zone>,
) : ViewModel() {
    private val _state = MutableStateFlow(
        ObjectCreationState(
            objectInfo = ObjectModel(
                geoJson = GeoJson(
                    zones = zones
                )
            )
        )
    )
    val state = _state.asStateFlow()

    private val _effects = MutableSharedFlow<ObjectCreationEffect>(extraBufferCapacity = 1)
    val effects = _effects.asSharedFlow()

    fun onEvent(event: ObjectCreationEvent) {
        when (event) {
            ObjectCreationEvent.BackClicked -> {
                if (_state.value.currentPlanIndex != null) {
                    _state.update { state ->
                        state.copy(
                            currentPlanIndex = null
                        )
                    }
                } else {
                    _effects.tryEmit(ObjectCreationEffect.NavigateBack)
                }
            }

            ObjectCreationEvent.CloseClicked -> {
                _effects.tryEmit(ObjectCreationEffect.CloseScreen)
            }

            is ObjectCreationEvent.ObjectInfoAddressChanged -> {
                _state.update { state ->
                    state.copy(
                        objectInfo = state.objectInfo.copy(
                            address = event.address
                        )
                    )
                }
            }

            is ObjectCreationEvent.ObjectInfoTitleChanged -> {
                _state.update { state ->
                    state.copy(
                        objectInfo = state.objectInfo.copy(
                            name = event.title
                        )
                    )
                }
            }

            ObjectCreationEvent.PlanCreated -> {
                _state.update { state ->
                    state.copy(
                        plans = state.plans + PlanModel(),
                        currentPlanIndex = state.plans.size
                    )
                }
            }

            is ObjectCreationEvent.PlanDescriptionChanged -> {
                _state.update { state ->
                    state.copy(
                        plans = state.plans.mapIndexed { index, plan ->
                            if (index == state.currentPlanIndex) {
                                plan.copy(description = event.description)
                            } else {
                                plan
                            }
                        }
                    )
                }
            }

            is ObjectCreationEvent.PlanFirstPlannedDateChanged -> {
                _state.update { state ->
                    state.copy(
                        plans = state.plans.mapIndexed { index, plan ->
                            if (index == state.currentPlanIndex) {
                                plan.copy(firstPlannedDate = event.date)
                            } else {
                                plan
                            }
                        }
                    )
                }
            }

            is ObjectCreationEvent.PlanNameChanged -> {
                _state.update { state ->
                    state.copy(
                        plans = state.plans.mapIndexed { index, plan ->
                            if (index == state.currentPlanIndex) {
                                plan.copy(name = event.name)
                            } else {
                                plan
                            }
                        }
                    )
                }
            }

            is ObjectCreationEvent.PlanSelected -> {
                _state.update { state ->
                    state.copy(
                        currentPlanIndex = event.index
                    )
                }
            }

            ObjectCreationEvent.SaveClicked -> {
                if (_state.value.currentPlanIndex != null) {
                    _state.update { state ->
                        state.copy(
                            currentPlanIndex = null
                        )
                    }
                } else {
                    _effects.tryEmit(ObjectCreationEffect.SaveObject)
                }
            }
        }
    }

}