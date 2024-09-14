package com.example.kotlinenjoyerstemplate.ui.components.block.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

data class HackathonBlockMainPart(
    val title: Text,
    val subtitle: Text? = null,
    val status: Text? = null,
) {

    data class Text(
        val text: String,
        val color: Color? = null,
        val style: TextStyle? = null,
    )
}
