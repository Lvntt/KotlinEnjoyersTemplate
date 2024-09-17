package com.example.kotlinenjoyerstemplate.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kotlinenjoyerstemplate.navigation.BottomNavButton
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme
import com.example.kotlinenjoyerstemplate.ui.util.NoRippleInteractionSource

@Composable
fun BottomNavBar(
    buttons: List<BottomNavButton>,
    navController: NavController,
    onButtonClick: (BottomNavButton) -> Unit,
    modifier: Modifier = Modifier,
    isLabeled: Boolean = true,
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar(
        modifier = modifier,
        containerColor = HackathonTheme.colors.common.staticWhite,
        contentColor = HackathonTheme.colors.text.primary.default,
    ) {
        buttons.forEach { button ->
            val isSelected = button.route.baseRoute == backStackEntry.value?.destination?.route

            NavigationBarItem(
                selected = isSelected,
                onClick = { onButtonClick(button) },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = button.iconId),
                        contentDescription = null,
                    )
                },
                label = if (isLabeled) {
                    {
                        Text(
                            text = stringResource(id = button.labelId),
                            style = HackathonTheme.typography.texts.textS,
                        )
                    }
                } else null,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = HackathonTheme.colors.common.accent,
                    selectedTextColor = HackathonTheme.colors.common.accent,
                    indicatorColor = HackathonTheme.colors.common.staticWhite,
                    unselectedIconColor = HackathonTheme.colors.icons.primary,
                    unselectedTextColor = HackathonTheme.colors.text.primary.default,
                ),
                interactionSource = NoRippleInteractionSource(),
            )
        }
    }
}