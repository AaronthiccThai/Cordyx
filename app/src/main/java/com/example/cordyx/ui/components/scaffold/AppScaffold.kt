package com.example.cordyx.ui.components.scaffold

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cordyx.ui.components.habit.HabitViewModel
import com.example.cordyx.ui.screens.HabitScreen
import com.example.cordyx.ui.screens.MainScreen
import com.example.cordyx.ui.screens.Routes
import com.example.cordyx.ui.screens.TitleScreen

@Composable
fun AppScaffold(navController: NavHostController, habitViewModel: HabitViewModel) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            BottomNavBar(
                currentRoute = currentRoute,
                onNavigate = {
                    route -> navController.navigate(route) {
                        launchSingleTop = true
                    }
                }
            )
        }
    ) { padding ->
        NavHost(navController = navController, startDestination = Routes.Title.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Routes.Title.route) { TitleScreen() }
            composable(Routes.Habits.route) { HabitScreen(habitViewModel) }
            composable(Routes.Main.route) { MainScreen()}
        }
    }
}