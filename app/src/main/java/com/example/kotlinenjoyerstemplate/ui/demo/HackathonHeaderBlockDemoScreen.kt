package com.example.kotlinenjoyerstemplate.ui.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.ui.common.ImageSource
import com.example.kotlinenjoyerstemplate.ui.components.header_block.HackathonHeaderBlock
import com.example.kotlinenjoyerstemplate.ui.components.header_block.model.HackathonHeaderBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.components.header_block.model.HackathonHeaderBlockRightPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun HackathonHeaderBlockDemoScreen(onBack: () -> Unit) = BaseDemoScreen(
    elementName = "HackathonHeaderBlock",
    onBack = onBack,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(HackathonTheme.colors.background.primary),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
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
                onClick = {},
            )
        )
        HackathonHeaderBlock(
            mainPart = HackathonHeaderBlockMainPart(
                title = HackathonHeaderBlockMainPart.Text(
                    text = "Title",
                ),
                subtitle = HackathonHeaderBlockMainPart.Text(
                    text = "Subtitle",
                ),
            ),
        )
        HackathonHeaderBlock(
            mainPart = HackathonHeaderBlockMainPart(
                title = HackathonHeaderBlockMainPart.Text(
                    text = "Title",
                ),
            ),
            rightPart = HackathonHeaderBlockRightPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_chevron_right_24dp,
                    contentDescription = null,
                ),
                sizeDp = 24,
                onClick = {},
            )
        )
        HackathonHeaderBlock(
            mainPart = HackathonHeaderBlockMainPart(
                title = HackathonHeaderBlockMainPart.Text(
                    text = "Title",
                ),
            ),
        )
    }
}