package com.example.kotlinenjoyerstemplate.object_plan.presentation.model

sealed interface ObjectPlanDetailsItem {

    data class GeneralInfoObject(
        val name: String,
        val address: String,
        val percentageComplete: String,
    ) : ObjectPlanDetailsItem

    data class Stages(
        val stages: List<Stage>,
        val chosenStage: Stage,
    ) : ObjectPlanDetailsItem {

        data class Stage(
            val name: String,
            val status: String,
            val plannedStartDate: String,
            val plannedEndDate: String,
            val actualStartDate: String,
            val actualEndDate: String,
            val documents: List<Document>,
        )

        data class Document(
            val title: String,
            val url: String,
            val extension: String,
        )
    }

    data class ObjectPlanDescription(
        val budget: String,
        val customer: String,
        val contractor: String,
        val plannedStartDate: String,
        val plannedEndDate: String,
        val actualStartDate: String,
        val actualEndDate: String,
        val warrantyEndDate: String,
    ) : ObjectPlanDetailsItem
}