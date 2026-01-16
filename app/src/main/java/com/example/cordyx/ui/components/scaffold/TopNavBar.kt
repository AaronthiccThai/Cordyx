package com.example.cordyx.ui.components.scaffold

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar(
    onAddHabit: () -> Unit,
    onEditHabit: () -> Unit,
    onSettings: () -> Unit
) {
    TopAppBar(
        title = { Text("Cordyx") },
        actions = {
            IconButton(onClick = onAddHabit) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Habit"
                )
            }

            IconButton(onClick = onEditHabit) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit Habits"
                )
            }

            IconButton(onClick = onSettings) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings"
                )
            }
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TopNavBarPreview(

) {
    TopAppBar(
        title = { Text("Cordyx") },

        actions = {
            IconButton(onClick = { Log.d("TAG","Add Habit") }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Habit"
                )
            }

            IconButton(onClick =  { Log.d("TAG","Edit Habit") }) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit Habits"
                )
            }

            IconButton(onClick = { Log.d("TAG","Settings") }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings"
                )
            }

        }
    )

}

