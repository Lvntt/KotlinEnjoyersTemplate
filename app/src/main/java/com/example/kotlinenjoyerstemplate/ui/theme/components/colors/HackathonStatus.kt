package com.example.kotlinenjoyerstemplate.ui.theme.components.colors

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.kotlinenjoyerstemplate.R

class HackathonStatus(
    val success: Color,
    val planned: Color,
    val mapSuccess: Color,
    val mapInProgress: Color,
    val mapPlanned: Color,
)

@Composable
fun getHackathonStatus() = HackathonStatus(
    success = colorResource(id = R.color.colorsStatusSuccess),
    planned = colorResource(id = R.color.colorsStatusPlanned),
    mapSuccess = colorResource(id = R.color.colorsStatusMapSuccess),
    mapInProgress = colorResource(id = R.color.colorsStatusMapInProgress),
    mapPlanned = colorResource(id = R.color.colorsStatusMapPlanned),
)
