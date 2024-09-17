package com.example.kotlinenjoyerstemplate.ui.theme.components.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

class HackathonTitleStyles(
    val title2XL: TextStyle,
    val titleXL: TextStyle,
    val titleL: TextStyle,
    val titleM: TextStyle,
    val titleS: TextStyle,
    val titleXS: TextStyle,
)

fun getHackathonTitleStyles() = HackathonTitleStyles(
    title2XL = TextStyle(
        fontFamily = getRobotoFlex(500),
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
    ),
    titleXL = TextStyle(
        fontFamily = getRobotoFlex(500),
        fontSize = 21.sp,
        lineHeight = 27.sp,
        letterSpacing = 0.sp,
    ),
    titleL = TextStyle(
        fontFamily = getRobotoFlex(500),
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
    ),
    titleM = TextStyle(
        fontFamily = getRobotoFlex(500),
        fontSize = 16.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.sp,
    ),
    titleS = TextStyle(
        fontFamily = getRobotoFlex(500),
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp,
    ),
    titleXS = TextStyle(
        fontFamily = getRobotoFlex(500),
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp,
    ),
)
