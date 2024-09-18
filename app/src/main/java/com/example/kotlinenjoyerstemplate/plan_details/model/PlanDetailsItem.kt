package com.example.kotlinenjoyerstemplate.plan_details.model

import com.example.kotlinenjoyerstemplate.common.StatusWorkEnum

sealed interface PlanDetailsItem {

    data class Header(
        val title: String,
    ) : PlanDetailsItem

    data class GeneralObjectInfo(
        val name: String,
        val address: String,
    ) : PlanDetailsItem

    data class TopBar(
        val planName: String,
        val planDescription: String,
        val planStatus: StatusWorkEnum,
    ) : PlanDetailsItem

    data class PlanStatus(
        val completePercentage: String,
        val creationDate: String,
    ) : PlanDetailsItem

    data class Contracts(
        val contracts: List<Contract>
    ) : PlanDetailsItem {

        data class Contract(
            val id: String,
            val name: String,
            val generalExecutorName: String,
        )
    }
}