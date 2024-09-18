package com.example.kotlinenjoyerstemplate.ui.components.block

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.kotlinenjoyerstemplate.ui.common.toPainter
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockLeftPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockRightPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun HackathonBlock(
    mainPart: HackathonBlockMainPart,
    modifier: Modifier = Modifier,
    leftPart: HackathonBlockLeftPart? = null,
    rightPart: HackathonBlockRightPart? = null,
    partsSpacedByDp: Int = 10,
    shape: Shape = RoundedCornerShape(12.dp),
    isFillMaxWidth: Boolean = false,
    backgroundColor: Color = HackathonTheme.colors.common.staticWhite,
    innerPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
) = Box(modifier = modifier) {
    Row(
        modifier = Modifier
            .clip(shape)
            .background(backgroundColor)
            .padding(innerPadding),
        horizontalArrangement = Arrangement.spacedBy(partsSpacedByDp.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        leftPart?.let { leftPart ->
            when (leftPart) {
                is HackathonBlockLeftPart.Icon -> {
                    Icon(
                        modifier = Modifier.size(leftPart.sizeDp.dp),
                        painter = leftPart.source.toPainter(),
                        contentDescription = leftPart.source.contentDescription,
                        tint = leftPart.source.tint ?: HackathonTheme.colors.icons.primary,
                    )
                }
                is HackathonBlockLeftPart.Image -> {
                    Image(
                        modifier = Modifier.size(
                            width = leftPart.widthDp.dp,
                            height = leftPart.heightDp.dp
                        ),
                        painter = leftPart.source.toPainter(),
                        contentDescription = leftPart.source.contentDescription,
                    )
                }
            }
        }
        Column(
            modifier = if (isFillMaxWidth) {
                Modifier.weight(1f)
            } else {
                Modifier
            },
        ) {
            mainPart.status?.let { status ->
                Text(
                    text = status.text,
                    color = status.color ?: HackathonTheme.colors.status.success,
                    style = status.style ?: HackathonTheme.typography.texts.textS,
                )
            }
            Text(
                text = mainPart.title.text,
                color = mainPart.title.color ?: HackathonTheme.colors.text.primary.default,
                style = mainPart.title.style ?: HackathonTheme.typography.texts.textL,
            )
            mainPart.subtitle?.let { subtitle ->
                Text(
                    text = subtitle.text,
                    color = subtitle.color ?: HackathonTheme.colors.text.secondary.default,
                    style = subtitle.style ?: HackathonTheme.typography.texts.textS,
                )
            }
        }
        rightPart?.let { rightPart ->
            when (rightPart) {
                is HackathonBlockRightPart.Icon -> {
                    val iconModifier = rightPart.onClick?.let {
                        Modifier.clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = ripple(
                                bounded = false,
                                radius = rightPart.sizeDp.dp,
                            ),
                            onClick = rightPart.onClick,
                        )
                    } ?: Modifier

                    Icon(
                        modifier = Modifier
                            .size(rightPart.sizeDp.dp)
                            .then(iconModifier),
                        painter = rightPart.source.toPainter(),
                        contentDescription = rightPart.source.contentDescription,
                    )
                }
            }
        }
    }
}