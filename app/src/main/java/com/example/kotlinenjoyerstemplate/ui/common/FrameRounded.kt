package com.example.kotlinenjoyerstemplate.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun FrameRounded(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(16.dp),
    backgroundColor: Color = HackathonTheme.colors.background.white,
    sidePadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
    content: @Composable () -> Unit,
) = Box(
    modifier = modifier
        .clip(shape)
        .background(backgroundColor)
        .padding(sidePadding)
        .fillMaxWidth()
) {
    content()
}