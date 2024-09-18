package com.example.kotlinenjoyerstemplate.object_plan.presentation.model

import com.example.kotlinenjoyerstemplate.common.StatusWorkEnum

sealed interface ObjectContractItem {

    data class Header(
        val title: String,
    ) : ObjectContractItem

    data class TopBar(
        val contractName: String,
        val generalExecutorName: String,
    ) : ObjectContractItem

    data class GeneralObjectInfo(
        val name: String,
        val address: String,
    ) : ObjectContractItem

    data class Stages(
        val stages: List<Stage>,
        val chosenStage: Stage,
    ) : ObjectContractItem {

        data class Stage(
            val name: String,
            val status: StatusWorkEnum,
            val subExecutorName: String,
            val subExecutorPhone: String,
            val subExecutorAddress: String,
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

    data class Contacts(
        val generalExecutorPhone: String,
        val customerPhone: String,
    ) : ObjectContractItem

    data class ContractDescription(
        val customerName: String,
        val generalExecutorName: String,
        val plannedStartDate: String,
        val plannedEndDate: String,
        val warrantyEndDate: String,
        val budget: String,
    ) : ObjectContractItem
}