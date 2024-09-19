package com.example.kotlinenjoyerstemplate.common

import androidx.annotation.ColorRes
import com.example.kotlinenjoyerstemplate.R

enum class StatusWorkEnum(
    val text: String,
    @ColorRes val colorId: Int,
) {
    PLANNED(
        text = "Запланировано",
        colorId = R.color.colorsStatusPlanned,
    ),
    PAUSED(
        text = "Приостановлено",
        colorId = R.color.colorsStatusPaused,
    ),
    RESUMED(
        text = "Возобновлено",
        colorId = R.color.colorsStatusResumed,
    ),
    IN_PROCESS(
        text = "В работе",
        colorId = R.color.colorsStatusInProcess,
    ),
    COMPLETED(
        text = "Выполнено",
        colorId = R.color.colorsStatusCompleted,
    ),
    CANCELLED(
        text = "Отменено",
        colorId = R.color.colorsStatusCancelled,
    ),
    NONE(
        text = "",
        colorId = R.color.colorsStatusCancelled,
    )
}