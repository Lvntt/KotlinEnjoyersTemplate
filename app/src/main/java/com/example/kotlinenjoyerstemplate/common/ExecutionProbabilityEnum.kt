package com.example.kotlinenjoyerstemplate.common

import androidx.annotation.ColorRes
import com.example.kotlinenjoyerstemplate.R

enum class ExecutionProbabilityEnum(
    val text: String,
    @ColorRes val colorId: Int,
) {
    HIGH(
        text = "Высокая",
        colorId = R.color.colorsStatusCompleted,
    ),
    MEDIUM(
        text = "Средняя",
        colorId = R.color.colorsStatusInProcess,
    ),
    LOW(
        text = "Низкая",
        colorId = R.color.colorsStatusCancelled,
    ),
}