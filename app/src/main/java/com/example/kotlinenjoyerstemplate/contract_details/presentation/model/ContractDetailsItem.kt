package com.example.kotlinenjoyerstemplate.contract_details.presentation.model

import com.example.kotlinenjoyerstemplate.common.StatusWorkEnum

sealed interface ContractDetailsItem {

    data class Header(
        val title: String,
    ) : ContractDetailsItem

    data class TopBar(
        val contractName: String,
        val generalExecutorName: String,
    ) : ContractDetailsItem

    data class GeneralInfoDetails(
        val name: String,
        val address: String,
    ) : ContractDetailsItem

    data class Stages(
        val stages: List<Stage>,
        val chosenStage: Stage?,
    ) : ContractDetailsItem {

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
    ) : ContractDetailsItem

    data class ContractDetailsDescription(
        val customerName: String,
        val generalExecutorName: String,
        val plannedStartDate: String,
        val plannedEndDate: String,
        val warrantyEndDate: String,
        val budget: String,
    ) : ContractDetailsItem
}