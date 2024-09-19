package com.example.kotlinenjoyerstemplate.create_screens.presentation.model

import com.example.kotlinenjoyerstemplate.create_screens.model.ObjectModel
import com.example.kotlinenjoyerstemplate.create_screens.model.PlanModel

data class ObjectCreationState(
    val objectInfo: ObjectModel,
    val plans: List<PlanModel> = emptyList(),
    val currentPlanIndex: Int? = null,
)