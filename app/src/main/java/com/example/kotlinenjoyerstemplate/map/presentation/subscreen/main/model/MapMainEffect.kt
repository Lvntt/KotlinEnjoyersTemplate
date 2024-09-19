package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model

sealed interface MapMainEffect {

    data object NavigateToNewObject : MapMainEffect

    data object OpenBottomSheet : MapMainEffect

    data object ShowLoadingError : MapMainEffect

}