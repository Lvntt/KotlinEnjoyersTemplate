package com.example.kotlinenjoyerstemplate.create_screens

import com.example.kotlinenjoyerstemplate.create_screens.presentation.CreationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun provideCreateScreensModule() = module {
    viewModel { parameters ->
        CreationViewModel(parameters.get())
    }
}