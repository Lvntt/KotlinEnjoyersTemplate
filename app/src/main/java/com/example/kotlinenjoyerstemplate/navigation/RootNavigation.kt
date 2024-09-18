package com.example.kotlinenjoyerstemplate.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlinenjoyerstemplate.map.MapScreen

sealed class RootNavDestination(override val baseRoute: String) : NavDestination {

    data object MapScreen : RootNavDestination("MapScreen")

}

@Composable
fun RootNavigation(
    navController: NavHostController,
    onCloseApp: () -> Unit,
) {

    BackHandler {
        if (navController.previousBackStackEntry == null) {
            onCloseApp()
        } else {
            navController.popBackStack()
        }
    }

    NavHost(
        navController = navController,
        startDestination = RootNavDestination.MapScreen.getDestination(),
    ) {
        composable(route = RootNavDestination.MapScreen.getDestination()) {
            MapScreen(navController = navController)
        }
    }
}