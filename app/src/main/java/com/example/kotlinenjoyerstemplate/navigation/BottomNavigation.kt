package com.example.kotlinenjoyerstemplate.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class BottomNavDestination(override val baseRoute: String) : NavDestination {

    data object Destination1 : BottomNavDestination("Destination1")

    data object Destination2 : BottomNavDestination("Destination2")

    data object Destination3 : BottomNavDestination("Destination3")

    data object Destination4 : BottomNavDestination("Destination4")

    data object DemoScreen : BottomNavDestination("DemoScreen")
}

@Composable
fun BottomNavigation(
    bottomNavController: NavHostController,
    rootNavController: NavHostController,
) {
    NavHost(
        navController = bottomNavController,
        startDestination = BottomNavDestination.Destination1.getDestination()
    ) {
        composable(route = BottomNavDestination.Destination1.getDestination()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = BottomNavDestination.Destination1.getDestination())
            }
        }
        composable(route = BottomNavDestination.Destination2.getDestination()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = BottomNavDestination.Destination2.getDestination())
            }
        }
        composable(route = BottomNavDestination.Destination3.getDestination()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = BottomNavDestination.Destination3.getDestination())
            }
        }
        composable(route = BottomNavDestination.Destination4.getDestination()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = BottomNavDestination.Destination4.getDestination())
            }
        }
        composable(route = BottomNavDestination.DemoScreen.getDestination()) {
            DemoNavigation()
        }
    }
}
