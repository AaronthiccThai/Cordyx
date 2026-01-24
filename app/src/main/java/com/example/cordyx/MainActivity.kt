package com.example.cordyx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cordyx.ui.theme.CordyxTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CordyxTheme {
                CordyxApp()
//                val navController = rememberNavController()
//                val xpViewModel = XpViewModel()
//                val habitViewModel = HabitViewModel()
//                AppScaffold(navController = navController, habitViewModel = habitViewModel)

            }
        }
    }
}

