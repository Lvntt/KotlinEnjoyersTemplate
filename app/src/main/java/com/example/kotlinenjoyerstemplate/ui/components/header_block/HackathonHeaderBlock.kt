package com.example.kotlinenjoyerstemplate.ui.components.header_block

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.ui.common.ImageSource
import com.example.kotlinenjoyerstemplate.ui.common.toPainter
import com.example.kotlinenjoyerstemplate.ui.components.header_block.model.HackathonHeaderBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.components.header_block.model.HackathonHeaderBlockRightPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun HackathonHeaderBlock(
    mainPart: HackathonHeaderBlockMainPart,
    modifier: Modifier = Modifier,
    rightPart: HackathonHeaderBlockRightPart? = null,
    backgroundColor: Color = HackathonTheme.colors.background.white,
    sidePadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
) = Box(modifier = modifier) {
    Row(
        modifier = Modifier
            .background(backgroundColor)
            .padding(sidePadding),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = mainPart.title.text,
                color = mainPart.title.color ?: HackathonTheme.colors.text.primary.default,
                style = mainPart.title.style ?: HackathonTheme.typography.titles.titleL,
            )
            mainPart.subtitle?.let { subtitle ->
                Text(
                    text = subtitle.text,
                    color = subtitle.color ?: HackathonTheme.colors.text.secondary.default,
                    style = subtitle.style ?: HackathonTheme.typography.titles.titleS,
                )
            }
        }
        rightPart?.let { rightPart ->
            when (rightPart) {
                is HackathonHeaderBlockRightPart.Icon -> {
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

@Preview
@Composable
private fun HackathonHeaderBlockPreview() = HackathonTheme {
    HackathonHeaderBlock(
        mainPart = HackathonHeaderBlockMainPart(
            title = HackathonHeaderBlockMainPart.Text(
                text = "Title",
            ),
            subtitle = HackathonHeaderBlockMainPart.Text(
                text = "Subtitle",
            ),
        ),
        rightPart = HackathonHeaderBlockRightPart.Icon(
            source = ImageSource.FromResource(
                resId = R.drawable.ic_chevron_right_24dp,
                contentDescription = null,
            ),
            sizeDp = 24,
        )
    )
}
