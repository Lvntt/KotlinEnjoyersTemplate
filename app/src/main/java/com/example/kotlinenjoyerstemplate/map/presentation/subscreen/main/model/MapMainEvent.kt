package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model

sealed interface MapMainEvent {

    data object AddNewObjectClicked : MapMainEvent

}