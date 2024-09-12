package com.example.kotlinenjoyerstemplate.ui.theme.components.colors

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.kotlinenjoyerstemplate.R

class HackathonIcons(
    val primary: Color,
)

@Composable
fun getHackathonIcons() = HackathonIcons(
    primary = colorResource(id = R.color.colorsIconsPrimary),
)