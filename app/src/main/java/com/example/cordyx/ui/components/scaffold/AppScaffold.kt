package com.example.cordyx.ui.components.scaffold

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cordyx.ui.components.habit.HabitViewModel
import com.example.cordyx.ui.screens.HabitScreen
import com.example.cordyx.ui.screens.MainScreen
import com.example.cordyx.ui.screens.Routes

@Composable
fun AppScaffold(habitViewModel: HabitViewModel) {
    val internalNavController = rememberNavController()
    val navBackStackEntry by internalNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopNavBar(
                onAddHabit = { Log.d("TAG", "Add Habit") },
                onEditHabit = { Log.d("TAG", "Edit Habit") },
                onSettings = { Log.d("TAG", "Settings") }
            )
        },
        bottomBar = {
            BottomNavBar(
                currentRoute = currentRoute,
                onNavigate = { route ->
                    internalNavController.navigate(route) {
                        popUpTo(internalNavController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { padding ->
        NavHost(
            navController = internalNavController,
            startDestination = Routes.Main.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Routes.Habits.route) { HabitScreen(habitViewModel) }
            composable(Routes.Main.route) { MainScreen() }
        }
    }
}
