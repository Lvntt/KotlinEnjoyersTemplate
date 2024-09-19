package com.example.kotlinenjoyerstemplate.core.data

class ObjectRepository(
    private val apiService: ObjectApiService,
) {

    suspend fun getObjectDetails(objectId: Long): ObjectView =
        apiService.getObjectDetails(objectId)

    suspend fun getPlanDetails(planId: Long): ObjectPlanView =
        apiService.getPlanDetails(planId)

    suspend fun getContractDetails(contractId: Long): ObjectContractView =
        apiService.getContractDetails(contractId)
}
