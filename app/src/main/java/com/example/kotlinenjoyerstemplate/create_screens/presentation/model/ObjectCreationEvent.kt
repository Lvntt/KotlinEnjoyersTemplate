package com.example.kotlinenjoyerstemplate.create_screens.presentation.model

sealed interface ObjectCreationEvent {

    data class ObjectInfoTitleChanged(val title: String) : ObjectCreationEvent

    data class ObjectInfoAddressChanged(val address: String) : ObjectCreationEvent

    data object PlanCreated : ObjectCreationEvent

    data class PlanSelected(val index: Int) : ObjectCreationEvent

    data class PlanNameChanged(val name: String) : ObjectCreationEvent

    data class PlanDescriptionChanged(val description: String) : ObjectCreationEvent

    data class PlanFirstPlannedDateChanged(val date: String) : ObjectCreationEvent

    data object SaveClicked : ObjectCreationEvent

    data object BackClicked : ObjectCreationEvent

    data object CloseClicked : ObjectCreationEvent

}