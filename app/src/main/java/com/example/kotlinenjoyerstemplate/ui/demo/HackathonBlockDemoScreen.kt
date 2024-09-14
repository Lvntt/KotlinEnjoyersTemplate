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
import com.example.kotlinenjoyerstemplate.ui.components.block.HackathonBlock
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockLeftPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockMainPart
import com.example.kotlinenjoyerstemplate.ui.components.block.model.HackathonBlockRightPart
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun HackathonBlockDemoScreen(onBack: () -> Unit) = BaseDemoScreen(
    elementName = "HackathonBlock",
    onBack = onBack,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(HackathonTheme.colors.background.primary),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        HackathonBlock(
            mainPart = HackathonBlockMainPart(
                title = HackathonBlockMainPart.Text(
                    text = "Title",
                ),
                status = HackathonBlockMainPart.Text(
                    text = "Status",
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Subtitle",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Image(
                source = ImageSource.FromResource(
                    resId = R.drawable.img_android,
                    contentDescription = null,
                ),
                widthDp = 40,
                heightDp = 25,
            ),
            rightPart = HackathonBlockRightPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_chevron_right_24dp,
                    contentDescription = null,
                ),
                sizeDp = 24,
                onClick = {}
            ),
            isFillMaxWidth = true,
        )
        HackathonBlock(
            mainPart = HackathonBlockMainPart(
                title = HackathonBlockMainPart.Text(
                    text = "Title",
                ),
                status = HackathonBlockMainPart.Text(
                    text = "Status",
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Subtitle",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Image(
                source = ImageSource.FromResource(
                    resId = R.drawable.img_android,
                    contentDescription = null,
                ),
                widthDp = 40,
                heightDp = 25,
            ),
            rightPart = HackathonBlockRightPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_chevron_right_24dp,
                    contentDescription = null,
                ),
                sizeDp = 24,
                onClick = {}
            )
        )
        HackathonBlock(
            mainPart = HackathonBlockMainPart(
                title = HackathonBlockMainPart.Text(
                    text = "Title",
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Subtitle",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Image(
                source = ImageSource.FromResource(
                    resId = R.drawable.img_android,
                    contentDescription = null,
                ),
                widthDp = 40,
                heightDp = 25,
            ),
        )
        HackathonBlock(
            mainPart = HackathonBlockMainPart(
                title = HackathonBlockMainPart.Text(
                    text = "Title",
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Subtitle",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Image(
                source = ImageSource.FromResource(
                    resId = R.drawable.img_android,
                    contentDescription = null,
                ),
                widthDp = 40,
                heightDp = 25,
            ),
            rightPart = HackathonBlockRightPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_chevron_right_24dp,
                    contentDescription = null,
                ),
                sizeDp = 24,
                onClick = {}
            )
        )
        HackathonBlock(
            mainPart = HackathonBlockMainPart(
                title = HackathonBlockMainPart.Text(
                    text = "Title",
                ),
            ),
            leftPart = HackathonBlockLeftPart.Image(
                source = ImageSource.FromResource(
                    resId = R.drawable.img_android,
                    contentDescription = null,
                ),
                widthDp = 40,
                heightDp = 25,
            )
        )
        HackathonBlock(
            mainPart = HackathonBlockMainPart(
                title = HackathonBlockMainPart.Text(
                    text = "Title",
                ),
                subtitle = HackathonBlockMainPart.Text(
                    text = "Subtitle",
                ),
            ),
            rightPart = HackathonBlockRightPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_chevron_right_24dp,
                    contentDescription = null,
                ),
                sizeDp = 24,
                onClick = {}
            )
        )
        HackathonBlock(
            mainPart = HackathonBlockMainPart(
                title = HackathonBlockMainPart.Text(
                    text = "Title",
                ),
                status = HackathonBlockMainPart.Text(
                    text = "Status",
                ),
            ),
            rightPart = HackathonBlockRightPart.Icon(
                source = ImageSource.FromResource(
                    resId = R.drawable.ic_chevron_right_24dp,
                    contentDescription = null,
                ),
                sizeDp = 24,
                onClick = {}
            )
        )
    }
}