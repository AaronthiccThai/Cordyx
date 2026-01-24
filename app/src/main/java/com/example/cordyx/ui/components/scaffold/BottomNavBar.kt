package com.example.cordyx.ui.components.scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.cordyx.ui.components.routes.Routes

@Composable
fun BottomNavBar(
    currentRoute: String?,
    onNavigate: (String) -> Unit,
) {
    val items = listOf(
        Routes.Schedule to Icons.Filled.Home,
        Routes.Setting to Icons.Filled.Settings
    )
    NavigationBar() {
        items.forEach { (route, icon) ->
            NavigationBarItem(
                selected = currentRoute == route.route,
                onClick = { onNavigate(route.route) },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = route.route
                    )
                },
                label = { Text(route.label) }
            )
        }
    }
}
