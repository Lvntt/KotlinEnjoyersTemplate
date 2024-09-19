package com.example.kotlinenjoyerstemplate.core.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ObjectApiService {

    @GET("object/{objectId}/matvey")
    suspend fun getObjectDetails(@Path("objectId") objectId: Long): ObjectView

    @GET("plans/{planId}/matvey")
    suspend fun getPlanDetails(@Path("planId") planId: Long): ObjectPlanView

    @GET("contracts/{contractId}/matvey")
    suspend fun getContractDetails(@Path("contractId") contractId: Long): ObjectContractView
}
