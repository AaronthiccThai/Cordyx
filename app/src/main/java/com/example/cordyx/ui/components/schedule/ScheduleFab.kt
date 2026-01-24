package com.example.cordyx.ui.components.schedule

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.example.cordyx.ui.components.routes.Routes

@Composable
fun ScheduleFab(currentRoute: String?, onClick: () -> Unit) {
    if (currentRoute == Routes.Schedule.route) { // Adjust route as needed
        FloatingActionButton(onClick = onClick) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Event"
            )
        }
    }
}
