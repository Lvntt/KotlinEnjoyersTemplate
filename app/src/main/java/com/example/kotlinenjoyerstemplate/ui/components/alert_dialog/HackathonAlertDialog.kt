package com.example.kotlinenjoyerstemplate.ui.components.alert_dialog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.components.alert_dialog.model.HackathonAlertDialogButton
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun HackathonAlertDialog(
    title: String,
    description: String,
    confirmButton: HackathonAlertDialogButton,
    dismissButton: HackathonAlertDialogButton? = null,
    onDismissRequest: () -> Unit,
    shape: Shape = RoundedCornerShape(12.dp),
) {
    AlertDialog(
        onDismissRequest = dismissButton?.onClick ?: onDismissRequest,
        shape = shape,
        containerColor = HackathonTheme.colors.background.white,
        title = {
            Column(
                modifier = Modifier.padding(bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    text = title,
                    color = HackathonTheme.colors.text.primary.default,
                    style = HackathonTheme.typography.texts.textXL,
                )
                Text(
                    text = description,
                    color = HackathonTheme.colors.text.secondary.default,
                    style = HackathonTheme.typography.texts.textM,
                )
            }
        },
        confirmButton = {
            Text(
                modifier = Modifier
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(),
                        onClick = confirmButton.onClick,
                    ),
                text = confirmButton.text,
                color = confirmButton.textColor ?: HackathonTheme.colors.common.accent,
                style = HackathonTheme.typography.titles.titleM,
            )
        },
        dismissButton = dismissButton?.let { button ->
            {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = ripple(),
                            onClick = button.onClick,
                        ),
                    text = button.text,
                    color = button.textColor ?: HackathonTheme.colors.text.primary.default,
                    style = HackathonTheme.typography.texts.textM,
                )
            }
        }
    )
}

@Preview
@Composable
private fun HackathonAlertDialogPreview() = HackathonTheme {
    HackathonAlertDialog(
        title = "Title",
        description = "Description",
        confirmButton = HackathonAlertDialogButton(
            text = "Confirm",
            onClick = {},
        ),
        dismissButton = HackathonAlertDialogButton(
            text = "Dismiss",
            onClick = {},
        ),
        onDismissRequest = {},
    )
}
