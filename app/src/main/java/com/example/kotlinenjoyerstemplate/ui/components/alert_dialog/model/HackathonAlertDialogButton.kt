package com.example.kotlinenjoyerstemplate.ui.components.alert_dialog.model

import androidx.compose.ui.graphics.Color

data class HackathonAlertDialogButton(
    val text: String,
    val onClick: () -> Unit,
    val textColor: Color? = null,
)
