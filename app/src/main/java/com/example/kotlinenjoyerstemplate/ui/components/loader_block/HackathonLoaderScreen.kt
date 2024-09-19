package com.example.kotlinenjoyerstemplate.ui.components.loader_block

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinenjoyerstemplate.ui.components.loader_button.HackathonLoaderButton
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun HackathonLoaderScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        HackathonLoaderButton.L()
    }
}

@Preview
@Composable
private fun HackathonLoaderBlockPreview() = HackathonTheme {
    HackathonLoaderScreen()
}
