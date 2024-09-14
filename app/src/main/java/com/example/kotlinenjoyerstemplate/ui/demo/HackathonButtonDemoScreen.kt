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
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButton
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors
import com.example.kotlinenjoyerstemplate.ui.components.button.model.HackathonButtonIcon
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun HackathonButtonDemoScreen(onBack: () -> Unit) = BaseDemoScreen(
    elementName = "HackathonButton",
    onBack = onBack,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(HackathonTheme.colors.background.primary),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            HackathonButton.L(
                onClick = {},
                text = "Обновить",
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.accent,
                    contentColor = HackathonTheme.colors.common.staticWhite,
                ),
                icon = HackathonButtonIcon(
                    resId = R.drawable.ic_renew_24dp,
                    sizeDp = 24,
                    tintColor = HackathonTheme.colors.common.staticWhite,
                ),
            )
            HackathonButton.M(
                onClick = {},
                text = "Обновить",
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.accent,
                    contentColor = HackathonTheme.colors.common.staticWhite,
                ),
                icon = HackathonButtonIcon(
                    resId = R.drawable.ic_renew_24dp,
                    sizeDp = 24,
                    tintColor = HackathonTheme.colors.common.staticWhite,
                ),
            )
            HackathonButton.S(
                onClick = {},
                text = "Обновить",
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.accent,
                    contentColor = HackathonTheme.colors.common.staticWhite,
                ),
            )
            HackathonButton.XS(
                onClick = {},
                text = "Обновить",
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.accent,
                    contentColor = HackathonTheme.colors.common.staticWhite,
                ),
            )
            HackathonButton.Icon(
                onClick = {},
                icon = HackathonButtonIcon(
                    resId = R.drawable.ic_renew_24dp,
                    sizeDp = 24,
                    tintColor = HackathonTheme.colors.common.staticWhite,
                ),
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.accent,
                    contentColor = HackathonTheme.colors.common.staticWhite,
                ),
            )
            HackathonButton.IconAlt(
                onClick = {},
                icon = HackathonButtonIcon(
                    resId = R.drawable.ic_renew_24dp,
                    sizeDp = 24,
                    tintColor = HackathonTheme.colors.common.staticWhite,
                ),
                buttonColors = hackathonButtonColors(
                    containerColor = HackathonTheme.colors.common.accent,
                    contentColor = HackathonTheme.colors.common.staticWhite,
                ),
            )
        }
    }
}