package com.example.kotlinenjoyerstemplate.ui.theme.components.typography

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import com.example.kotlinenjoyerstemplate.R

class HackathonTypography(
    val titles: HackathonTitleStyles,
    val texts: HackathonTextStyles,
)

fun getHackathonTypography() = HackathonTypography(
    titles = getHackathonTitleStyles(),
    texts = getHackathonTextStyles(),
)

@OptIn(ExperimentalTextApi::class)
fun getRobotoFlex(weight: Int) = FontFamily(
    Font(
        resId = R.font.roboto_flex_variable,
        variationSettings = FontVariation.Settings(FontVariation.weight(weight)),
    )
)

val LocalHackathonTypography = staticCompositionLocalOf<HackathonTypography> {
    error("CompositionLocal LocalHackathonTypography not present")
}
