package com.example.kotlinenjoyerstemplate.object_plan.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ObjectApiService {

    @GET("projects/{projectId}")
    suspend fun getObjectDetails(@Path("projectId") projectId: String): ObjectModel
}