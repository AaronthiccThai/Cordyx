package com.example.cordyx

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cordyx.ui.components.habit.HabitViewModel
import com.example.cordyx.ui.components.scaffold.AppScaffold
import com.example.cordyx.ui.screens.Routes
import com.example.cordyx.ui.screens.TitleScreen

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
            val habitViewModel = viewModel<HabitViewModel>()
            AppScaffold(habitViewModel)
        }
    }
}
