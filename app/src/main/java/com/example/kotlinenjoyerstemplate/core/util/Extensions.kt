package com.example.kotlinenjoyerstemplate.core.util

import com.example.kotlinenjoyerstemplate.common.StatusWorkEnum
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun String.toStatusWorkEnum() = when (this) {
    "PLANNED" -> StatusWorkEnum.PLANNED
    "IN_PROCESS" -> StatusWorkEnum.IN_PROCESS
    "COMPLETED" -> StatusWorkEnum.COMPLETED
    "PAUSED" -> StatusWorkEnum.PAUSED
    "RESUMED" -> StatusWorkEnum.RESUMED
    "CANCELED" -> StatusWorkEnum.CANCELLED
    else -> StatusWorkEnum.NONE
}

fun Int.toMoneyFormat(): String {
    val symbols = DecimalFormatSymbols(Locale("ru")).apply {
        groupingSeparator = ' '
    }
    val formatter = DecimalFormat("#,###", symbols)
    return formatter.format(this)
}