package com.example.kotlinenjoyerstemplate.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlinenjoyerstemplate.ui.navigation.BottomNavBar
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun BottomNavWrapper(
    rootNavController: NavHostController,
    onCloseApp: () -> Unit,
) {
    val bottomNavController = rememberNavController()

    BackHandler {
        if (bottomNavController.previousBackStackEntry == null) {
            onCloseApp()
        } else {
            bottomNavController.popBackStack()
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                buttons = BottomNavButtons.buttons,
                navController = bottomNavController,
                onButtonClick = { button ->
                    bottomNavController.navigate(button.route.baseRoute)
                }
            )
        }
    ) { paddings ->
        Box(
            modifier = Modifier
                .padding(paddings)
                .fillMaxSize()
                .background(HackathonTheme.colors.background.grey),
        ) {
            BottomNavigation(
                bottomNavController = bottomNavController,
                rootNavController = rootNavController,
            )
        }
    }
}