package com.example.kotlinenjoyerstemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButton
import com.example.kotlinenjoyerstemplate.ui.components.button.HackathonButtonBase
import com.example.kotlinenjoyerstemplate.ui.components.button.hackathonButtonColors
import com.example.kotlinenjoyerstemplate.ui.components.button.model.HackathonButtonIcon
import com.example.kotlinenjoyerstemplate.ui.components.loader_button.HackathonLoaderButton
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HackathonTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(HackathonTheme.colors.background.primary)
                        .padding(horizontal = 32.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(64.dp),
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
            }
        }
    }
}
