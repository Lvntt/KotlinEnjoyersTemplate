package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model

sealed interface MapMainEvent {

    data object AddNewObjectClicked : MapMainEvent

    data class ObjectClicked(val id: String) : MapMainEvent

}