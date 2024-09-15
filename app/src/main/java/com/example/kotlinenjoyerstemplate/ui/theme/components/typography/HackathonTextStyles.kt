package com.example.kotlinenjoyerstemplate.ui.theme.components.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

class HackathonTextStyles(
    val textXL: TextStyle,
    val textL: TextStyle,
    val textM: TextStyle,
    val textS: TextStyle,
    val textXS: TextStyle,
)

fun getHackathonTextStyles() = HackathonTextStyles(
    textXL = TextStyle(
        fontFamily = getRobotoFlex(400),
        fontSize = 21.sp,
        lineHeight = 27.sp,
        letterSpacing = 0.sp,
    ),
    textL = TextStyle(
        fontFamily = getRobotoFlex(400),
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
    ),
    textM = TextStyle(
        fontFamily = getRobotoFlex(400),
        fontSize = 16.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.sp,
    ),
    textS = TextStyle(
        fontFamily = getRobotoFlex(400),
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp,
    ),
    textXS = TextStyle(
        fontFamily = getRobotoFlex(400),
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp,
    ),
)
