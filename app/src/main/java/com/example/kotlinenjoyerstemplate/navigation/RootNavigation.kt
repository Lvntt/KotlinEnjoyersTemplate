package com.example.kotlinenjoyerstemplate.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.kotlinenjoyerstemplate.map.MapScreen
import com.example.kotlinenjoyerstemplate.map.data.model.ZoneList
import com.google.gson.Gson

sealed class RootNavDestination(override val baseRoute: String) : NavDestination {

    data object MapScreen : RootNavDestination("MapScreen")

    data object ObjectCreation : RootNavDestination("ObjectCreation") {
        override val arguments: List<String>
            get() = listOf("zonesArg")
    }

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
        composable(route = RootNavDestination.ObjectCreation.getDestination(), arguments = listOf(
            navArgument("zonesArg") {
                type = NavType.StringType
            }
        )) {
            val zones = Gson().fromJson(it.arguments?.getString("zonesArg"), ZoneList::class.java)

        }
    }
}