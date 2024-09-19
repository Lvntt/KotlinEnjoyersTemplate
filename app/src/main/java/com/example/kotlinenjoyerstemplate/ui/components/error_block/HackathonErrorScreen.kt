package com.example.kotlinenjoyerstemplate.ui.components.error_block

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun HackathonErrorScreen(
    onRetry: () -> Unit,
    backgroundColor: Color = HackathonTheme.colors.background.grey,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.TopCenter,
    ) {
        HackathonErrorBlock(onRetry = onRetry)
    }
}
