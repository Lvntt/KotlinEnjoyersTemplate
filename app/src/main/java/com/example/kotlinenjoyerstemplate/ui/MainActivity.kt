package com.example.kotlinenjoyerstemplate.ui

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.kotlinenjoyerstemplate.navigation.RootNavigation
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val activity = (LocalContext.current as? Activity)

            HackathonTheme {
                RootNavigation(
                    navController = navController,
                    onCloseApp = {
                        activity?.finish()
                    }
                )
            }
        }
    }
}
