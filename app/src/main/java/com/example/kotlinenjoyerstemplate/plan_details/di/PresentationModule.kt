package com.example.kotlinenjoyerstemplate.plan_details.di

import com.example.kotlinenjoyerstemplate.plan_details.viewmodel.PlanDetailsFactory
import com.example.kotlinenjoyerstemplate.plan_details.viewmodel.PlanDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun planDetailsPresentationModule() = module {

    factoryOf(::PlanDetailsFactory)

    viewModel { parameters ->
        PlanDetailsViewModel(
            planId = parameters.get(),
            get(), get(),
        )
    }
}