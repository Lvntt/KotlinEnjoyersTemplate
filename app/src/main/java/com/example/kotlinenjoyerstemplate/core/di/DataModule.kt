package com.example.kotlinenjoyerstemplate.core.di

import com.example.kotlinenjoyerstemplate.common.Constants
import com.example.kotlinenjoyerstemplate.core.data.ObjectApiService
import com.example.kotlinenjoyerstemplate.core.data.ObjectRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private fun provideLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

private fun provideOkHttpClient(
    loggingInterceptor: HttpLoggingInterceptor
): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    baseUrl: String
): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun provideObjectApiService(
    retrofit: Retrofit,
): ObjectApiService =
    retrofit.create(ObjectApiService::class.java)

fun provideObjectRepository(
    apiService: ObjectApiService,
): ObjectRepository =
    ObjectRepository(apiService)

fun coreDataModule() = module {

    singleOf(::provideLoggingInterceptor)
    singleOf(::provideOkHttpClient)
    single {
        provideRetrofit(get(), Constants.BASE_URL)
    }
    singleOf(::provideObjectApiService)
    singleOf(::provideObjectRepository)
}