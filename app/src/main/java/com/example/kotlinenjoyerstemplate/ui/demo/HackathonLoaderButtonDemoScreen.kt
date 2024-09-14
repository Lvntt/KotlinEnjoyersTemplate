package com.example.kotlinenjoyerstemplate.ui.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors
import com.example.kotlinenjoyerstemplate.ui.components.loader_button.HackathonLoaderButton
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun HackathonLoaderButtonDemoScreen(onBack: () -> Unit) = BaseDemoScreen(
    elementName = "HackathonLoaderButton",
    onBack = onBack,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(HackathonTheme.colors.background.primary),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        HackathonLoaderButton.L(
            buttonColors = hackathonButtonColors(
                containerColor = HackathonTheme.colors.common.accent,
                contentColor = HackathonTheme.colors.common.staticWhite,
            ),
        )
        HackathonLoaderButton.M(
            buttonColors = hackathonButtonColors(
                containerColor = HackathonTheme.colors.common.accent,
                contentColor = HackathonTheme.colors.common.staticWhite,
            ),
        )
        HackathonLoaderButton.S(
            buttonColors = hackathonButtonColors(
                containerColor = HackathonTheme.colors.common.accent,
                contentColor = HackathonTheme.colors.common.staticWhite,
            ),
        )
    }
}