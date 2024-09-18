package com.example.kotlinenjoyerstemplate.object_plan.data

class ObjectRepository(
    private val apiService: ObjectApiService,
) {

    suspend fun getObjectDetails(projectId: String): ObjectModel =
        apiService.getObjectDetails(projectId)
}