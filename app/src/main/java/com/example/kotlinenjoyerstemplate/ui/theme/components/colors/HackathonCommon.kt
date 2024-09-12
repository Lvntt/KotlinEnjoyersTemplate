package com.example.kotlinenjoyerstemplate.ui.theme.components.colors

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.kotlinenjoyerstemplate.R

class HackathonCommon(
    val accent: Color,
    val staticWhite: Color,
    val staticBlack: Color,
)

@Composable
fun getHackathonCommon() = HackathonCommon(
    accent = colorResource(id = R.color.colorsCommonAccent),
    staticWhite = colorResource(id = R.color.colorsCommonStaticWhite),
    staticBlack = colorResource(id = R.color.colorsCommonStaticBlack),
)
