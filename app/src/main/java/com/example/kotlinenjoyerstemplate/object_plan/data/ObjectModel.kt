package com.example.kotlinenjoyerstemplate.object_plan.data

data class ObjectModel(
    val name: String,
    val geoJson: GeoJson,
    val plans: List<ObjectPlanModel>,
)

data class ObjectPlanModel(
    val name: String,
    val description: String,
    val firstPlannedStartDate: String,
    val percentageComplete: Int,
    val contracts: List<ObjectContractModel>,
)

data class ObjectContractModel(
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

data class Organization(
    val organizationId: String,
    val name: String,
    val phone: String,
    val address: String,
)

data class ObjectStageModel(
    val subExecutorOrganization: Organization,
    val name: String,
    val plannedStartDate: String,
    val plannedEndDate: String,
    val actualStartDate: String,
    val actualEndDate: String,
    val status: String,
    val documents: List<ObjectStageDocumentModel>,
)

data class ObjectStageDocumentModel(
    val documentId: Int,
    val name: String,
    val downloadUrl: String,
    val format: String,
)
