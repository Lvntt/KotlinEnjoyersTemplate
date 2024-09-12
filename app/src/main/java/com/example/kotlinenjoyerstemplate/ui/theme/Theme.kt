package com.example.kotlinenjoyerstemplate.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.example.kotlinenjoyerstemplate.ui.theme.components.colors.HackathonColors
import com.example.kotlinenjoyerstemplate.ui.theme.components.typography.HackathonTypography
import com.example.kotlinenjoyerstemplate.ui.theme.components.colors.LocalHackathonColors
import com.example.kotlinenjoyerstemplate.ui.theme.components.typography.LocalHackathonTypography
import com.example.kotlinenjoyerstemplate.ui.theme.components.colors.getHackathonColors
import com.example.kotlinenjoyerstemplate.ui.theme.components.typography.getHackathonTypography

@Composable
fun HackathonTheme(
    colors: HackathonColors = getHackathonColors(),
    typography: HackathonTypography = getHackathonTypography(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalHackathonColors provides colors,
        LocalHackathonTypography provides typography,
        content = content,
    )
}

object HackathonTheme {

    val colors: HackathonColors
        @Composable
        @ReadOnlyComposable
        get() = LocalHackathonColors.current

    val typography: HackathonTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalHackathonTypography.current
}
