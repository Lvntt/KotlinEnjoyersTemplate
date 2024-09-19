package com.example.kotlinenjoyerstemplate.contract_details.di

import com.example.kotlinenjoyerstemplate.contract_details.presentation.viewmodel.ContractDetailsFactory
import com.example.kotlinenjoyerstemplate.contract_details.presentation.viewmodel.ContractDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun contractDetailsPresentationModule() = module {

    factoryOf(::ContractDetailsFactory)

    viewModel { parameters ->
        ContractDetailsViewModel(
            contractId = parameters.get(),
            get(), get(),
        )
    }
}