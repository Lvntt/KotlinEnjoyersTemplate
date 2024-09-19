package com.example.kotlinenjoyerstemplate.plan_details.viewmodel

import com.example.kotlinenjoyerstemplate.core.data.ObjectPlanView
import com.example.kotlinenjoyerstemplate.core.util.toStatusWorkEnum
import com.example.kotlinenjoyerstemplate.plan_details.model.PlanDetailsItem
import com.example.kotlinenjoyerstemplate.ui.util.toRussianFormattedDate

class PlanDetailsFactory {

    fun getPlanDetailsUi(model: ObjectPlanView): List<PlanDetailsItem> {
        return buildList {
            add(getPlanStatusHeader())
            add(getPlanStatusModel(model))
            add(getContractsHeader())
            add(getContractsModel(model))
            add(getGeneralInfoHeader())
            add(getGeneralInfoModel(model))
        }
    }

    fun getPlanDetailsTopBar(model: ObjectPlanView) = PlanDetailsItem.TopBar(
        planName = model.plan.planName,
        planDescription = model.plan.description,
        planStatus = model.plan.status.toStatusWorkEnum(),
    )

    private fun getPlanStatusHeader() = PlanDetailsItem.Header(
        title = "Статус плана",
    )

    private fun getPlanStatusModel(model: ObjectPlanView) = PlanDetailsItem.PlanStatus(
        completePercentage = "${model.percentageComplete}%",
        creationDate = model.creationDate.toRussianFormattedDate(),
    )

    private fun getContractsHeader() = PlanDetailsItem.Header(
        title = "Контракты",
    )

    private fun getContractsModel(model: ObjectPlanView) = PlanDetailsItem.Contracts(
        contracts = model.contracts.map { contractModel ->
            PlanDetailsItem.Contracts.Contract(
                id = contractModel.contractId,
                name = contractModel.contractName,
                generalExecutorName = contractModel.executorName,
            )
        }
    )

    private fun getGeneralInfoHeader() = PlanDetailsItem.Header(
        title = "Информация об объекте",
    )

    private fun getGeneralInfoModel(model: ObjectPlanView) = PlanDetailsItem.GeneralObjectInfo(
        name = model.`object`.name,
        address = model.`object`.address,
    )

}