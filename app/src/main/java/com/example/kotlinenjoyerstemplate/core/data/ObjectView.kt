package com.example.kotlinenjoyerstemplate.core.data

data class ObjectView(
    val `object`: ObjectShortInfoView,
    val plans: List<PlanShortInfoView>,
)

data class ObjectShortInfoView(
    val objectId: Long,
    val name: String,
    val address: String,
)

data class PlanShortInfoView(
    val status: String,
    val planId: Long,
    val planName: String,
    val description: String?,
)

data class ObjectPlanView(
    val `object`: ObjectShortInfoView,
    val plan: PlanShortInfoView,
    val percentageComplete: Int,
    val creationDate: String,
    val contracts: List<ContractShortInfoView>,
)

data class ContractShortInfoView(
    val contractId: Long,
    val executorName: String,
    val contractName: String,
)

data class ObjectContractView(
    val `object`: ObjectShortInfoView,
    val contract: ContractView,
)

data class ContractView(
    val name: String,
    val budget: Int,
    val plannedStartDate: String,
    val plannedEndDate: String,
    val warrantyEndDate: String,
    val nameCustomer: String,
    val phoneCustomer: String,
    val nameGeneralExecutor: String,
    val phoneGeneralExecutor: String,
    val status: String,
    val generalExecutorOrganization: Organization,
    val customerOrganization: Organization,
    val stages: List<ObjectStageModel>,
)
