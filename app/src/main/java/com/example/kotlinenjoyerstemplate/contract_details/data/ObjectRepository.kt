package com.example.kotlinenjoyerstemplate.contract_details.data

class ObjectRepository(
    private val apiService: ObjectApiService,
) {

    suspend fun getObjectDetails(projectId: String): ObjectModel =
        apiService.getObjectDetails(projectId)
}