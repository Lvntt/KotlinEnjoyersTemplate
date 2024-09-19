package com.example.kotlinenjoyerstemplate.core.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ObjectApiService {

    @GET("object/{objectId}")
    suspend fun getObjectDetails(@Path("objectId") objectId: Long): ObjectView

    // TODO актуализировать путь
    @GET()
    suspend fun getPlanDetails(@Path("planId") planId: Long): ObjectPlanView

    // TODO актуализировать путь
    @GET()
    suspend fun getContractDetails(@Path("contractId") contractId: Long): ObjectContractView
}
