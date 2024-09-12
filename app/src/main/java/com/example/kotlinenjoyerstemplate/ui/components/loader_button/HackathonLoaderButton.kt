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
        buttonColors: ButtonColors = hackathonButtonColors(),
        contentPadding: PaddingValues = PaddingValues(all = 20.dp),
        shape: Shape = RoundedCornerShape(8.dp),
        isFillMaxWidth: Boolean = false,
    ) = HackathonLoaderButtonBase(
        modifier = modifier,
        onClick = onClick,
        buttonColors = buttonColors,
        contentPadding = contentPadding,
        shape = shape,
        isFillMaxWidth = isFillMaxWidth,
    )

    @Composable
    fun M(
        modifier: Modifier = Modifier,
        onClick: (() -> Unit)? = null,
        buttonColors: ButtonColors = hackathonButtonColors(),
        contentPadding: PaddingValues = PaddingValues(all = 12.dp),
        shape: Shape = RoundedCornerShape(8.dp),
        isFillMaxWidth: Boolean = false,
    ) = HackathonLoaderButtonBase(
        modifier = modifier,
        onClick = onClick,
        buttonColors = buttonColors,
        contentPadding = contentPadding,
        shape = shape,
        isFillMaxWidth = isFillMaxWidth,
    )

    @Composable
    fun S(
        modifier: Modifier = Modifier,
        onClick: (() -> Unit)? = null,
        buttonColors: ButtonColors = hackathonButtonColors(),
        contentPadding: PaddingValues = PaddingValues(all = 6.dp),
        shape: Shape = RoundedCornerShape(8.dp),
        isFillMaxWidth: Boolean = false,
    ) = HackathonLoaderButtonBase(
        modifier = modifier,
        onClick = onClick,
        buttonColors = buttonColors,
        contentPadding = contentPadding,
        shape = shape,
        isFillMaxWidth = isFillMaxWidth,
    )
}