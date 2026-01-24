package com.example.cordyx.ui.components.routes

sealed class Routes(val route: String, val label: String) {
    object Title : Routes("title", "Title")

    object Setting: Routes("setting", "Setting")
    object App: Routes("app", "App")

    object Schedule: Routes("schedule", "Schedule")
}