package com.example.kotlinenjoyerstemplate.contract_details.presentation.viewmodel

import com.example.kotlinenjoyerstemplate.contract_details.presentation.model.ContractDetailsItem
import com.example.kotlinenjoyerstemplate.core.data.ObjectContractView
import com.example.kotlinenjoyerstemplate.core.util.toMoneyFormat
import com.example.kotlinenjoyerstemplate.core.util.toStatusWorkEnum
import com.example.kotlinenjoyerstemplate.ui.util.toRussianFormattedDate

class ContractDetailsFactory {

    fun getContractDetailsUi(model: ObjectContractView): List<ContractDetailsItem> {
        return buildList {
            add(getStagesHeader())
            add(getStagesModel(model))
            add(getContractDescriptionHeader())
            add(getContractDescriptionModel(model))
            add(getContactsHeader())
            add(getContactsModel(model))
            add(getGeneralInfoHeader())
            add(getGeneralInfoModel(model))
        }
    }

    fun getContractTopBar(model: ObjectContractView) = ContractDetailsItem.TopBar(
        contractName = model.contract.name,
        generalExecutorName = model.contract.nameGeneralExecutor,
    )

    private fun getStagesHeader() = ContractDetailsItem.Header(
        title = "Этапы работ"
    )

    private fun getStagesModel(model: ObjectContractView): ContractDetailsItem.Stages {
        val stagesUi = model.contract.stages.map { stageModel ->
            ContractDetailsItem.Stages.Stage(
                name = stageModel.name,
                status = stageModel.status.toStatusWorkEnum(),
                subExecutorName = stageModel.subExecutorOrganization.name,
                subExecutorPhone = stageModel.subExecutorOrganization.phone,
                subExecutorAddress = stageModel.subExecutorOrganization.address,
                plannedStartDate = stageModel.plannedStartDate.toRussianFormattedDate(),
                plannedEndDate = stageModel.plannedEndDate.toRussianFormattedDate(),
                actualStartDate = stageModel.actualStartDate.toRussianFormattedDate(),
                actualEndDate = stageModel.actualEndDate.toRussianFormattedDate(),
                documents = stageModel.documents.map { documentModel ->
                    ContractDetailsItem.Stages.Document(
                        title = documentModel.name,
                        url = documentModel.downloadUrl,
                        extension = documentModel.format,
                    )
                }
            )
        }
        return ContractDetailsItem.Stages(
            stages = stagesUi,
            chosenStage = stagesUi.firstOrNull(),
        )
    }

    private fun getContractDescriptionHeader() = ContractDetailsItem.Header(
        title = "Описание контракта"
    )

    private fun getContractDescriptionModel(model: ObjectContractView) = ContractDetailsItem.ContractDetailsDescription(
        customerName = model.contract.nameCustomer,
        generalExecutorName = model.contract.nameGeneralExecutor,
        plannedEndDate = model.contract.plannedEndDate.toRussianFormattedDate(),
        plannedStartDate = model.contract.plannedStartDate.toRussianFormattedDate(),
        warrantyEndDate = model.contract.warrantyEndDate.toRussianFormattedDate(),
        budget = model.contract.budget.toMoneyFormat(),
    )

    private fun getContactsHeader() = ContractDetailsItem.Header(
        title = "Контакты"
    )

    private fun getContactsModel(model: ObjectContractView) = ContractDetailsItem.Contacts(
        generalExecutorPhone = model.contract.phoneGeneralExecutor,
        customerPhone = model.contract.phoneCustomer,
    )

    private fun getGeneralInfoHeader() = ContractDetailsItem.Header(
        title = "Информация об объекте",
    )

    private fun getGeneralInfoModel(model: ObjectContractView) = ContractDetailsItem.GeneralInfoDetails(
        name = model.`object`.name,
        address = model.`object`.address,
    )
}