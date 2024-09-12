package com.example.kotlinenjoyerstemplate.ui.theme.components.colors

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.kotlinenjoyerstemplate.R

class HackathonStatus(
    val success: Color,
)

@Composable
fun getHackathonStatus() = HackathonStatus(
    success = colorResource(id = R.color.colorsStatusSuccess),
)
