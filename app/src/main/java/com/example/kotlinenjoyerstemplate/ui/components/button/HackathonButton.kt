package com.example.kotlinenjoyerstemplate.ui.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.components.button.model.HackathonButtonIcon
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

object HackathonButton {

    @Composable
    fun L(
        onClick: () -> Unit,
        text: String,
        modifier: Modifier = Modifier,
        icon: HackathonButtonIcon? = null,
        textStyle: TextStyle = HackathonTheme.typography.titles.titleL,
        buttonColors: ButtonColors = hackathonButtonColors(),
        contentPadding: PaddingValues = PaddingValues(horizontal = 28.dp, vertical = 16.dp),
        shape: Shape = RoundedCornerShape(12.dp),
        isEnabled: Boolean = true,
        isFillMaxWidth: Boolean = false,
    ) = HackathonButtonBase(
        onClick = onClick,
        text = text,
        modifier = modifier,
        icon = icon,
        textStyle = textStyle,
        buttonColors = buttonColors,
        contentPadding = contentPadding,
        shape = shape,
        isEnabled = isEnabled,
        isFillMaxWidth = isFillMaxWidth,
    )

    @Composable
    fun M(
        onClick: () -> Unit,
        text: String,
        modifier: Modifier = Modifier,
        icon: HackathonButtonIcon? = null,
        textStyle: TextStyle = HackathonTheme.typography.titles.titleM,
        buttonColors: ButtonColors = hackathonButtonColors(),
        contentPadding: PaddingValues = PaddingValues(horizontal = 10.dp, vertical = 10.dp),
        shape: Shape = RoundedCornerShape(8.dp),
        isEnabled: Boolean = true,
        isFillMaxWidth: Boolean = false,
    ) = HackathonButtonBase(
        onClick = onClick,
        text = text,
        modifier = modifier,
        icon = icon,
        textStyle = textStyle,
        buttonColors = buttonColors,
        contentPadding = contentPadding,
        shape = shape,
        isEnabled = isEnabled,
        isFillMaxWidth = isFillMaxWidth,
    )

    @Composable
    fun S(
        onClick: () -> Unit,
        text: String,
        modifier: Modifier = Modifier,
        textStyle: TextStyle = HackathonTheme.typography.titles.titleS,
        buttonColors: ButtonColors = hackathonButtonColors(),
        contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 10.5.dp),
        shape: Shape = RoundedCornerShape(8.dp),
        isEnabled: Boolean = true,
        isFillMaxWidth: Boolean = false,
    ) = HackathonButtonBase(
        onClick = onClick,
        text = text,
        modifier = modifier,
        icon = null,
        textStyle = textStyle,
        buttonColors = buttonColors,
        contentPadding = contentPadding,
        shape = shape,
        isEnabled = isEnabled,
        isFillMaxWidth = isFillMaxWidth,
    )

    @Composable
    fun XS(
        onClick: () -> Unit,
        text: String,
        modifier: Modifier = Modifier,
        textStyle: TextStyle = HackathonTheme.typography.titles.titleXS,
        buttonColors: ButtonColors = hackathonButtonColors(),
        contentPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
        shape: Shape = RoundedCornerShape(6.dp),
        isEnabled: Boolean = true,
        isFillMaxWidth: Boolean = false,
    ) = HackathonButtonBase(
        onClick = onClick,
        text = text,
        modifier = modifier,
        icon = null,
        textStyle = textStyle,
        buttonColors = buttonColors,
        contentPadding = contentPadding,
        shape = shape,
        isEnabled = isEnabled,
        isFillMaxWidth = isFillMaxWidth,
    )

    @Composable
    fun Icon(
        onClick: () -> Unit,
        icon: HackathonButtonIcon,
        modifier: Modifier = Modifier,
        buttonColors: ButtonColors = hackathonButtonColors(),
        contentPadding: PaddingValues = PaddingValues(all = 10.dp),
        shape: Shape = RoundedCornerShape(12.dp),
        isEnabled: Boolean = true,
    ) = HackathonButtonBase(
        onClick = onClick,
        text = null,
        modifier = modifier,
        icon = icon,
        buttonColors = buttonColors,
        contentPadding = contentPadding,
        shape = shape,
        isEnabled = isEnabled,
    )

    @Composable
    fun IconAlt(
        onClick: () -> Unit,
        icon: HackathonButtonIcon,
        modifier: Modifier = Modifier,
        buttonColors: ButtonColors = hackathonButtonColors(),
        contentPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        shape: Shape = RoundedCornerShape(12.dp),
        isEnabled: Boolean = true,
    ) = HackathonButtonBase(
        onClick = onClick,
        text = null,
        modifier = modifier,
        icon = icon,
        buttonColors = buttonColors,
        contentPadding = contentPadding,
        shape = shape,
        isEnabled = isEnabled,
    )
}

@Preview
@Composable
private fun HackathonButtonLPreview() = HackathonTheme {
    HackathonButton.L(
        onClick = {},
        text = "Обновить",
    )
}
