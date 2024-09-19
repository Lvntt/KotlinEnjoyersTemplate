package com.example.kotlinenjoyerstemplate.ui.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun String.toRussianFormattedDate(): String {
    val date = LocalDate.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    val outputFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale("ru"))
    return date.format(outputFormatter)
}