package com.example.kotlinenjoyerstemplate.ui.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.components.button.model.HackathonButtonIcon
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun hackathonButtonColors(
    containerColor: Color = HackathonTheme.colors.common.staticWhite,
    contentColor: Color = HackathonTheme.colors.text.primary.default,
    disabledContainerColor: Color = HackathonTheme.colors.background.grey,
    disabledContentColor: Color = HackathonTheme.colors.text.primary.default,
) = ButtonColors(
    containerColor = containerColor,
    contentColor = contentColor,
    disabledContainerColor = disabledContainerColor,
    disabledContentColor = disabledContentColor,
)

@Composable
fun HackathonButtonBase(
    onClick: () -> Unit,
    text: String?,
    modifier: Modifier = Modifier,
    icon: HackathonButtonIcon? = null,
    textStyle: TextStyle = HackathonTheme.typography.titles.titleL,
    buttonColors: ButtonColors = hackathonButtonColors(),
    contentPadding: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
    shape: Shape = RoundedCornerShape(8.dp),
    isEnabled: Boolean = true,
    isFillMaxWidth: Boolean = false,
) = Box(modifier) {
    Box(
        modifier = Modifier
            .clip(shape)
            .background(buttonColors.containerColor)
            .then(
                if (isEnabled)
                    Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(),
                        onClick = onClick,
                    )
                else Modifier
            )
            .then(
                if (isFillMaxWidth)
                    Modifier.fillMaxWidth()
                else Modifier
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(contentPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            icon?.let { icon ->
                Icon(
                    modifier = Modifier.size(icon.sizeDp.dp),
                    imageVector = ImageVector.vectorResource(id = icon.resId),
                    contentDescription = null,
                    tint = icon.tintColor ?: HackathonTheme.colors.icons.primary,
                )
            }
            text?.let { text ->
                Text(
                    text = text,
                    style = textStyle,
                    color = buttonColors.contentColor,
                )
            }
        }
    }
}

@Composable
fun HackathonButton(
    onClick: () -> Unit,
    text: String?,
    modifier: Modifier = Modifier,
    icon: HackathonButtonIcon? = null,
    textStyle: TextStyle = HackathonTheme.typography.titles.titleL,
    buttonColors: ButtonColors = hackathonButtonColors(),
    contentPadding: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
    shape: Shape = RoundedCornerShape(8.dp),
    isEnabled: Boolean = true,
    isFillMaxWidth: Boolean = false,
) = Box(modifier) {
    Box(
        modifier = Modifier
            .clip(shape)
            .background(buttonColors.containerColor)
            .then(
                if (isEnabled)
                    Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(),
                        onClick = onClick,
                    )
                else Modifier
            )
            .then(
                if (isFillMaxWidth)
                    Modifier.fillMaxWidth()
                else Modifier
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(contentPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            text?.let { text ->
                Text(
                    text = text,
                    style = textStyle,
                    color = buttonColors.contentColor,
                )
            }
            icon?.let { icon ->
                Icon(
                    modifier = Modifier.size(icon.sizeDp.dp),
                    imageVector = ImageVector.vectorResource(id = icon.resId),
                    contentDescription = null,
                    tint = icon.tintColor ?: HackathonTheme.colors.icons.primary,
                )
            }
        }
    }
}

@Preview
@Composable
private fun HackathonButtonBasePreview() = HackathonTheme {
    HackathonButtonBase(
        onClick = {},
        text = "Обновить",
    )
}