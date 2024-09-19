package com.example.kotlinenjoyerstemplate.create_screens.model

data class ContractModel(
    val name: String,
    val budget: Int,
    val plannedStartDate: String,
    val plannedEndDate: String,
    val warrantyEndDate: String,
    val nameCustomer: String,
    val phoneCustomer: String,
    val nameGeneralExecutor: String,
    val phoneGeneralExecutor: String,
    //......
)
