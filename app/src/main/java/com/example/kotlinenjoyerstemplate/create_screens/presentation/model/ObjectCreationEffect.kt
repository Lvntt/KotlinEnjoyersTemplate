package com.example.kotlinenjoyerstemplate.create_screens.presentation.model

sealed interface ObjectCreationEffect {

    data object CloseScreen : ObjectCreationEffect

}