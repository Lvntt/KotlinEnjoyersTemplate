package com.example.kotlinenjoyerstemplate.ui.components.create_topappbar

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTopAppBar(
    expandedHeight: Dp,
    title: String,
    navigationIconOnClick: () -> Unit,
    actionIconOnClick: () -> Unit,
) {
    CenterAlignedTopAppBar(
        expandedHeight = expandedHeight,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = HackathonTheme.colors.background.white,
            titleContentColor = HackathonTheme.colors.text.primary.default,
            navigationIconContentColor = HackathonTheme.colors.icons.primary,
            actionIconContentColor = HackathonTheme.colors.icons.primary,
        ),
        title = {
            Text(
                text = title,
                style = HackathonTheme.typography.titles.titleL,
            )
        },
        navigationIcon = {
            IconButton(
                onClick = navigationIconOnClick,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_back_24dp),
                    contentDescription = "Назад",
                )
            }
        },
        actions = {
            IconButton(
                onClick = actionIconOnClick,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_cancel_24dp),
                    contentDescription = "Отмена",
                )
            }
        },
    )
}
