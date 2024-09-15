package com.example.kotlinenjoyerstemplate.ui.theme.components.colors

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.kotlinenjoyerstemplate.R

class HackathonBackground(
    val grey: Color,
    val white: Color,
)

@Composable
fun getHackathonBackground() = HackathonBackground(
    grey = colorResource(id = R.color.colorsBackgroundGrey),
    white = colorResource(id = R.color.colorsBackgroundWhite),
)
