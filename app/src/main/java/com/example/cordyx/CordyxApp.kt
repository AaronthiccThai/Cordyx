package com.example.cordyx

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cordyx.ui.components.scaffold.AppScaffold
import com.example.cordyx.ui.components.routes.Routes
import com.example.cordyx.ui.components.routes.TitleScreen

@Composable
fun CordyxApp() {
    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        startDestination = Routes.Title.route
    ) {
        composable(Routes.Title.route) {
            TitleScreen(
                onFinished = {
                    rootNavController.navigate(Routes.App.route) {
                        popUpTo(Routes.Title.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.App.route) {
            AppScaffold()
        }
    }
}
