package com.example.kotlinenjoyerstemplate.ui.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.components.alert_dialog.HackathonAlertDialog
import com.example.kotlinenjoyerstemplate.ui.components.alert_dialog.model.HackathonAlertDialogButton
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButton
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun HackathonAlertDialogDemoScreen(onBack: () -> Unit) = BaseDemoScreen(
    elementName = "HackatonAlertDialog",
    onBack = onBack,
) {
    var isDialogShown by remember { mutableStateOf(false) }

    if (isDialogShown) {
        HackathonAlertDialog(
            title = "Title",
            description = "Description",
            confirmButton = HackathonAlertDialogButton(
                text = "Confirm",
                onClick = {},
            ),
            dismissButton = HackathonAlertDialogButton(
                text = "Dismiss",
                onClick = { isDialogShown = false },
            ),
            onDismissRequest = { isDialogShown = false },
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(HackathonTheme.colors.background.grey),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        HackathonButton.L(
            onClick = { isDialogShown = !isDialogShown },
            text = "Show Dialog",
        )
    }
}