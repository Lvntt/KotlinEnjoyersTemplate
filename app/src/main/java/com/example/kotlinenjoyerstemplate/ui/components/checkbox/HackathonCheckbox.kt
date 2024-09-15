package com.example.kotlinenjoyerstemplate.ui.components.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun HackathonCheckbox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    shape: Shape = RoundedCornerShape(4.dp),
    modifier: Modifier = Modifier,
) {
    val accentColor = HackathonTheme.colors.common.accent
    val bgColor = if (isChecked) {
        accentColor
    } else {
        Color.Unspecified
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(shape)
                .background(bgColor)
                .then(
                    if (!isChecked) {
                        Modifier.border(
                            width = 2.dp,
                            color = accentColor,
                            shape = shape,
                        )
                    } else {
                        Modifier
                    }
                )
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple(
                        bounded = false,
                        radius = 12.dp,
                    ),
                    onClick = {
                        onCheckedChange(!isChecked)
                    }
                ),
            contentAlignment = Alignment.Center,
        ) {
            if (isChecked) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_tick_24dp),
                    contentDescription = null,
                    tint = HackathonTheme.colors.common.staticWhite,
                )
            }
        }
    }

}
