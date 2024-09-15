package com.example.kotlinenjoyerstemplate.ui.components.hackathon_switch

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun HackathonSwitch(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val thumbPosition by animateFloatAsState(
        targetValue = if (isChecked) 1f else 0f,
        label = "thumbPositionAnimation",
    )
    val circleRadius = if (isChecked) 8.dp else 6.dp
    val interactionSource = remember { MutableInteractionSource() }

    val whiteColor = HackathonTheme.colors.common.staticWhite
    val accentColor = HackathonTheme.colors.common.accent
    val blueGrayColor = HackathonTheme.colors.elements.blueGray

    Box(
        modifier = modifier
            .size(width = 44.dp, height = 24.dp)
            .background(color = Color.Transparent)
            .clickable(
                onClick = { onCheckedChange(!isChecked) },
                interactionSource = interactionSource,
                indication = null
            )
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val thumbColor = if (isChecked) whiteColor else blueGrayColor

            drawRoundRect(
                color = if (isChecked) accentColor else blueGrayColor,
                size = Size(size.width, size.height),
                cornerRadius = CornerRadius(x = 16.dp.toPx(), y = 16.dp.toPx()),
                style = if (isChecked) Fill else Stroke(width = 2.dp.toPx())
            )

            val thumbOffset = calculateThumbOffset(
                start = 12.dp.toPx(),
                stop = size.width - 12.dp.toPx(),
                fraction = thumbPosition
            )

            drawCircle(
                color = thumbColor,
                radius = circleRadius.toPx(),
                center = Offset(x = thumbOffset, y = size.height / 2)
            )
        }
    }
}

private fun calculateThumbOffset(
    start: Float,
    stop: Float,
    fraction: Float
): Float = start + (stop - start) * fraction
