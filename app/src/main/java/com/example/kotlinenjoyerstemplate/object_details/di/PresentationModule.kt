package com.example.kotlinenjoyerstemplate.object_details.di

import com.example.kotlinenjoyerstemplate.object_details.presentation.viewmodel.ObjectDetailsFactory
import com.example.kotlinenjoyerstemplate.object_details.presentation.viewmodel.ObjectDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun objectDetailsPresentationModule() = module {

    factoryOf(::ObjectDetailsFactory)

    viewModel { parameters ->
        ObjectDetailsViewModel(
            objectId = parameters.get(),
            get(), get(),
        )
    }
}