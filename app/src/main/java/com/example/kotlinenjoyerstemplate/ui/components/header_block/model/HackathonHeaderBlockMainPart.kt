package com.example.kotlinenjoyerstemplate.ui.components.header_block.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

data class HackathonHeaderBlockMainPart(
    val title: Text,
    val subtitle: Text? = null,
) {

    data class Text(
        val text: String,
        val color: Color? = null,
        val style: TextStyle? = null,
    )
}
