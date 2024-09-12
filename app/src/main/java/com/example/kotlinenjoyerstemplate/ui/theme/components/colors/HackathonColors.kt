package com.example.kotlinenjoyerstemplate.ui.theme.components.colors

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

class HackathonColors(
    val text: HackathonText,
    val icons: HackathonIcons,
    val background: HackathonBackground,
    val elements: HackathonElements,
    val common: HackathonCommon,
    val status: HackathonStatus,
)

@Composable
fun getHackathonColors() = HackathonColors(
    text = getHackathonText(),
    icons = getHackathonIcons(),
    background = getHackathonBackground(),
    elements = getHackathonElements(),
    common = getHackathonCommon(),
    status = getHackathonStatus(),
)

val LocalHackathonColors = staticCompositionLocalOf<HackathonColors> {
    error("CompositionLocal LocalHackathonColors not present")
}
