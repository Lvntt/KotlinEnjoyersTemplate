package com.example.kotlinenjoyerstemplate.ui.theme.components.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

class HackathonTitleStyles(
    val titleL: TextStyle,
    val titleS: TextStyle,
)

fun getHackathonTitleStyles() = HackathonTitleStyles(
    titleL = TextStyle(
        fontFamily = getRobotoFlex(500),
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
    ),
    titleS = TextStyle(
        fontFamily = getRobotoFlex(500),
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp,
    ),
)
