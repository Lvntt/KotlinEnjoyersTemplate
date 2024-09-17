package com.example.kotlinenjoyerstemplate.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class RootNavDestination(override val baseRoute: String) : NavDestination {

     data object Onboarding : RootNavDestination("Onboarding")

     data object Home : RootNavDestination("Home")
}

@Composable
fun RootNavigation(
    navController: NavHostController,
    onCloseApp: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = RootNavDestination.Onboarding.getDestination(),
    ) {
        composable(route = RootNavDestination.Onboarding.getDestination()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = RootNavDestination.Onboarding.getDestination())
                    Button(
                        onClick = {
                            navController.navigate(RootNavDestination.Home.getNavigationRoute())
                        }
                    ) {
                        Text(text = "To Bottom Navigation")
                    }
                }
            }
        }
        composable(route = RootNavDestination.Home.getDestination()) {
            BottomNavWrapper(
                rootNavController = navController,
                onCloseApp = onCloseApp,
            )
        }
    }
}