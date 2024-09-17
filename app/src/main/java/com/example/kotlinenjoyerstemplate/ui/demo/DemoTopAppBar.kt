package com.example.kotlinenjoyerstemplate.ui.demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoTopAppBar(
    title: String,
    onBack: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = HackathonTheme.typography.titles.title2XL,
                color = HackathonTheme.colors.text.primary.default,
            )
        },
        navigationIcon = {
            Icon(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(
                            bounded = false,
                            radius = 16.dp,
                        ),
                        onClick = onBack,
                    ),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_back_24dp),
                contentDescription = stringResource(id = R.string.back),
            )
        },
        colors = TopAppBarColors(
            containerColor = HackathonTheme.colors.common.staticWhite,
            scrolledContainerColor = HackathonTheme.colors.common.staticWhite,
            navigationIconContentColor = HackathonTheme.colors.icons.primary,
            titleContentColor = HackathonTheme.colors.text.primary.default,
            actionIconContentColor = HackathonTheme.colors.icons.primary,
        )
    )
}

@Preview
@Composable
private fun DemoTopAppBarPreview() = HackathonTheme {
    DemoTopAppBar("HackathonButton", {})
}
