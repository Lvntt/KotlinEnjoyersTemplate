package com.example.kotlinenjoyerstemplate.ui.components.loader_button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors

object HackathonLoaderButton {

    @Composable
    fun L(
        modifier: Modifier = Modifier,
        onClick: (() -> Unit)? = null,
        loaderSizeDp: Int = 48,
        strokeWidthDp: Int = 6,
        buttonColors: ButtonColors = hackathonButtonColors(),
        contentPadding: PaddingValues = PaddingValues(all = 20.dp),
        shape: Shape = RoundedCornerShape(8.dp),
        isFillMaxWidth: Boolean = false,
    ) = HackathonLoaderButtonBase(
        modifier = modifier,
        onClick = onClick,
        loaderSizeDp = loaderSizeDp,
        strokeWidthDp = strokeWidthDp,
        buttonColors = buttonColors,
        contentPadding = contentPadding,
        shape = shape,
        isFillMaxWidth = isFillMaxWidth,
    )

    @Composable
    fun M(
        modifier: Modifier = Modifier,
        onClick: (() -> Unit)? = null,
        loaderSizeDp: Int = 32,
        strokeWidthDp: Int = 4,
        buttonColors: ButtonColors = hackathonButtonColors(),
        contentPadding: PaddingValues = PaddingValues(all = 12.dp),
        shape: Shape = RoundedCornerShape(8.dp),
        isFillMaxWidth: Boolean = false,
    ) = HackathonLoaderButtonBase(
        modifier = modifier,
        onClick = onClick,
        loaderSizeDp = loaderSizeDp,
        strokeWidthDp = strokeWidthDp,
        buttonColors = buttonColors,
        contentPadding = contentPadding,
        shape = shape,
        isFillMaxWidth = isFillMaxWidth,
    )

    @Composable
    fun S(
        modifier: Modifier = Modifier,
        onClick: (() -> Unit)? = null,
        loaderSizeDp: Int = 24,
        strokeWidthDp: Int = 3,
        buttonColors: ButtonColors = hackathonButtonColors(),
        contentPadding: PaddingValues = PaddingValues(all = 8.dp),
        shape: Shape = RoundedCornerShape(8.dp),
        isFillMaxWidth: Boolean = false,
    ) = HackathonLoaderButtonBase(
        modifier = modifier,
        onClick = onClick,
        loaderSizeDp = loaderSizeDp,
        strokeWidthDp = strokeWidthDp,
        buttonColors = buttonColors,
        contentPadding = contentPadding,
        shape = shape,
        isFillMaxWidth = isFillMaxWidth,
    )
}