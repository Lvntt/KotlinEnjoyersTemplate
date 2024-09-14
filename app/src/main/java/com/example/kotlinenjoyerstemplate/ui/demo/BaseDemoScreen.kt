package com.example.kotlinenjoyerstemplate.ui.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun BaseDemoScreen(
    elementName: String,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Scaffold(
        topBar = {
            DemoTopAppBar(
                title = elementName,
                onBack = onBack,
            )
        }
    ) { paddings ->
        Box(
            modifier = modifier
                .background(HackathonTheme.colors.background.primary)
                .padding(16.dp)
                .padding(paddings),
        ) {
            content()
        }
    }
}