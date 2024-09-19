package com.example.kotlinenjoyerstemplate.map.di

import com.example.kotlinenjoyerstemplate.map.data.repository.ObjectRepository
import com.example.kotlinenjoyerstemplate.map.presentation.subscreen.MapSubScreenStore
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun provideMapPresentationModule() = module {
    viewModelOf(::MapSubScreenStore)
    singleOf(::ObjectRepository)
}