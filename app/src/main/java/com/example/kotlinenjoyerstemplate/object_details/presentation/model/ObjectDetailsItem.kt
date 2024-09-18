package com.example.kotlinenjoyerstemplate.object_details.presentation.model

import com.example.kotlinenjoyerstemplate.common.StatusWorkEnum

sealed interface ObjectDetailsItem {

    data class Header(
        val title: String,
    ) : ObjectDetailsItem

    data class GeneralObjectInfo(
        val name: String,
        val address: String,
    ) : ObjectDetailsItem

    data class Plans(
        val plans: List<Plan>
    ) : ObjectDetailsItem {

        data class Plan(
            val id: String,
            val name: String,
            val description: String,
            val status: StatusWorkEnum,
        )
    }
}