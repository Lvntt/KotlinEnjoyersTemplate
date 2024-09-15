package com.example.kotlinenjoyerstemplate.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinenjoyerstemplate.ui.demo.HackathonAlertDialogDemoScreen
import com.example.kotlinenjoyerstemplate.ui.demo.HackathonBlockDemoScreen
import com.example.kotlinenjoyerstemplate.ui.demo.HackathonButtonDemoScreen
import com.example.kotlinenjoyerstemplate.ui.demo.HackathonCheckboxDemoScreen
import com.example.kotlinenjoyerstemplate.ui.demo.HackathonHeaderBlockDemoScreen
import com.example.kotlinenjoyerstemplate.ui.demo.HackathonLoaderButtonDemoScreen
import com.example.kotlinenjoyerstemplate.ui.demo.HackathonSwitchDemoScreen
import com.example.kotlinenjoyerstemplate.ui.demo.OverviewDemoScreen
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

sealed class DemoNavDestination(val baseRoute: String) {

    data object OverviewDemo : DemoNavDestination("OverviewDemo")

    data object ButtonDemo : DemoNavDestination("ButtonDemo")

    data object LoaderButtonDemo : DemoNavDestination("LoaderButtonDemo")

    data object BlockDemo : DemoNavDestination("BlockDemo")

    data object HeaderBlockDemo : DemoNavDestination("HeaderBlockDemo")

    data object CheckboxDemo : DemoNavDestination("CheckboxDemo")

    data object SwitchDemo : DemoNavDestination("SwitchDemo")

    data object AlertDialogDemo : DemoNavDestination("AlertDialogDemo")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val onBack: () -> Unit = remember { { navController.navigateUp() } }

            HackathonTheme {
                NavHost(
                    navController = navController,
                    startDestination = DemoNavDestination.OverviewDemo.baseRoute,
                ) {
                    composable(route = DemoNavDestination.OverviewDemo.baseRoute) {
                        OverviewDemoScreen(navController = navController)
                    }
                    composable(route = DemoNavDestination.ButtonDemo.baseRoute) {
                        HackathonButtonDemoScreen(onBack)
                    }
                    composable(route = DemoNavDestination.LoaderButtonDemo.baseRoute) {
                        HackathonLoaderButtonDemoScreen(onBack)
                    }
                    composable(route = DemoNavDestination.BlockDemo.baseRoute) {
                        HackathonBlockDemoScreen(onBack)
                    }
                    composable(route = DemoNavDestination.HeaderBlockDemo.baseRoute) {
                        HackathonHeaderBlockDemoScreen(onBack)
                    }
                    composable(route = DemoNavDestination.CheckboxDemo.baseRoute) {
                        HackathonCheckboxDemoScreen(onBack)
                    }
                    composable(route = DemoNavDestination.SwitchDemo.baseRoute) {
                        HackathonSwitchDemoScreen(onBack)
                    }
                    composable(route = DemoNavDestination.AlertDialogDemo.baseRoute) {
                        HackathonAlertDialogDemoScreen(onBack)
                    }
                }
            }
        }
    }
}
