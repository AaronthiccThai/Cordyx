package com.example.cordyx.ui.components.scaffold

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cordyx.ui.components.routes.Routes
import com.example.cordyx.ui.components.schedule.ScheduleBlock
import com.example.cordyx.ui.components.schedule.ScheduleFab
import com.example.cordyx.ui.components.schedule.ScheduleScreen
import com.example.cordyx.ui.components.schedule.ScheduleViewModel
import com.example.cordyx.ui.components.settings.SettingsScreen
import com.example.cordyx.ui.components.settings.SettingsViewModel

@Composable
fun AppScaffold() {
    val internalNavController = rememberNavController()
    val navBackStackEntry by internalNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val scheduleViewModel: ScheduleViewModel = viewModel()
    val settingViewModel: SettingsViewModel = viewModel()
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AddEventDialog(
            onDismiss = { showDialog = false },
            onConfirm = { day, hour, title ->
                scheduleViewModel.addEvent(ScheduleBlock(hour, title))
                showDialog = false
            }
        )
    }

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
        },
        floatingActionButton = {
            ScheduleFab(currentRoute, onClick = { showDialog = true })
        }
    ) { padding ->
        NavHost(
            navController = internalNavController,
            startDestination = Routes.Schedule.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Routes.Setting.route) { SettingsScreen(settingViewModel) }
            composable(Routes.Schedule.route) {
                ScheduleScreen(scheduleViewModel, settingViewModel) }
        }
    }
}
