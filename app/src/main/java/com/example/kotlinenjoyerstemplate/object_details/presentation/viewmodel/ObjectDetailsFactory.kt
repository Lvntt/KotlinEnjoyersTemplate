package com.example.kotlinenjoyerstemplate.object_details.presentation.viewmodel

import com.example.kotlinenjoyerstemplate.core.data.ObjectView
import com.example.kotlinenjoyerstemplate.core.util.toStatusWorkEnum
import com.example.kotlinenjoyerstemplate.object_details.presentation.model.ObjectDetailsItem

class ObjectDetailsFactory {

    fun getObjectDetailsUi(model: ObjectView): List<ObjectDetailsItem> {
        return buildList {
            add(getGeneralInfoHeader())
            add(getGeneralInfoModel(model))
            add(getPlansHeader())
            add(getPlansModel(model))
        }
    }

    private fun getGeneralInfoHeader() = ObjectDetailsItem.Header(
        title = "Информация об объекте",
    )

    private fun getGeneralInfoModel(model: ObjectView) = ObjectDetailsItem.GeneralObjectInfo(
        name = model.`object`.name,
        address = model.`object`.address,
    )

    private fun getPlansHeader() = ObjectDetailsItem.Header(
        title = "Планы",
    )

    private fun getPlansModel(model: ObjectView) = ObjectDetailsItem.Plans(
        plans = model.plans.map { planModel ->
            ObjectDetailsItem.Plans.Plan(
                id = planModel.planId,
                name = planModel.planName,
                description = planModel.description,
                status = planModel.status.toStatusWorkEnum(),
            )
        }
    )
}