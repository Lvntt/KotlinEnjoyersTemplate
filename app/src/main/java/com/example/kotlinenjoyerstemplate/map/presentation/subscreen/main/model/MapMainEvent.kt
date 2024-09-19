package com.example.kotlinenjoyerstemplate.map.presentation.subscreen.main.model

sealed interface MapMainEvent {

    data object AddNewObjectClicked : MapMainEvent

    data class ObjectClicked(val index: Int) : MapMainEvent

    data object ObjectUnselected : MapMainEvent

}