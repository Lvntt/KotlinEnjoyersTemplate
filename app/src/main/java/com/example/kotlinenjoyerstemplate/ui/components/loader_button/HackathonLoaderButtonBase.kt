package com.example.kotlinenjoyerstemplate.ui.components.loader_button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors

@Composable
fun HackathonLoaderButtonBase(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    loaderSizeDp: Int = 32,
    strokeWidthDp: Int = 4,
    buttonColors: ButtonColors = hackathonButtonColors(),
    contentPadding: PaddingValues = PaddingValues(all = 20.dp),
    shape: Shape = RoundedCornerShape(8.dp),
    isFillMaxWidth: Boolean = false,
) = Box(modifier) {
    Box(
        modifier = Modifier
            .clip(shape)
            .background(buttonColors.containerColor)
            .then(
                if (onClick != null)
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
        CircularProgressIndicator(
            modifier = Modifier
                .padding(contentPadding)
                .size(loaderSizeDp.dp),
            color = buttonColors.contentColor,
            strokeWidth = strokeWidthDp.dp,
        )
    }
}