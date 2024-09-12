package com.example.kotlinenjoyerstemplate.ui.theme.components.colors

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.kotlinenjoyerstemplate.R

class HackathonText(
    val primary: HackathonTextColorState,
    val secondary: HackathonTextColorState,
)

class HackathonTextColorState(
    val default: Color,
    val disabled: Color,
)

/**
 * На текущий момент disabled цвета дублируют default цвета и их использование не имеет смысла.
 * Это будет изменено в будущем, поэтому это состояние существует.
 */
@Composable
fun getHackathonText() = HackathonText(
    primary = HackathonTextColorState(
        default = colorResource(id = R.color.colorsTextPrimaryDefault),
        disabled = colorResource(id = R.color.colorsTextPrimaryDefault),
    ),
    secondary = HackathonTextColorState(
        default = colorResource(id = R.color.colorsTextSecondaryDefault),
        disabled = colorResource(id = R.color.colorsTextSecondaryDefault),
    ),
)