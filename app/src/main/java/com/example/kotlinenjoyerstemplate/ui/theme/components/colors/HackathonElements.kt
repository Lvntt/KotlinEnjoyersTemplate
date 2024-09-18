package com.example.kotlinenjoyerstemplate.ui.theme.components.colors

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.kotlinenjoyerstemplate.R

class HackathonElements(
    val lightGray: Color,
    val darkGray: Color,
    val blueGray: Color,
    val mapYellow: Color,
    val link: Color,
)

@Composable
fun getHackathonElements() = HackathonElements(
    lightGray = colorResource(id = R.color.colorsElementsLightGray),
    darkGray = colorResource(id = R.color.colorsElementsDarkGray),
    blueGray = colorResource(id = R.color.colorsElementsDarkGray),
    link = colorResource(id = R.color.colorsElementsLink),
    mapYellow = colorResource(id = R.color.colorsElementsMapYellow),
)
