package com.example.cordyx.ui.components.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEventDialog(
    onDismiss: () -> Unit,
    onConfirm: (day: String, hour: Int, title: String) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("Monday") }
    var hour by remember { mutableStateOf("") }

    val days = listOf(
        "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday", "Sunday"
    )
    val hours = listOf(
            "12 AM", "1 AM", "2 AM", "3 AM", "4 AM", "5 AM",
            "6 AM", "7 AM", "8 AM", "9 AM", "10 AM", "11 AM",
            "12 PM", "1 PM", "2 PM", "3 PM", "4 PM", "5 PM",
            "6 PM", "7 PM", "8 PM", "9 PM", "10 PM", "11 PM"
    )


    var expandedDay by remember { mutableStateOf(false)}
    var expandedHour by remember { mutableStateOf(false)}

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add New Event") },
        text = {
            Column {
                // Event title
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Event Title") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Day selection
                ExposedDropdownMenuBox(
                    expanded = expandedDay,
                    onExpandedChange = { expandedDay = !expandedDay }
                ) {
                    OutlinedTextField(
                        value = day,
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Day")},
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expandedDay)
                        },
                        modifier = Modifier
                            .menuAnchor(MenuAnchorType.PrimaryNotEditable)
                            .fillMaxWidth()
                    )
                    ExposedDropdownMenu(
                        expanded = expandedDay,
                        onDismissRequest = { expandedDay = false }

                    ) {
                        days.forEach { option ->
                            DropdownMenuItem(
                                text = { Text(option) },
                                onClick = {
                                    day = option
                                    expandedDay = false
                                }

                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Time selection
                ExposedDropdownMenuBox(
                    expanded = expandedHour,
                    onExpandedChange = { expandedHour = !expandedHour }

                ) {
                    OutlinedTextField(
                        value = hour,
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Hour (0-23)") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expandedHour)
                        },
                        modifier = Modifier
                            .menuAnchor(MenuAnchorType.PrimaryNotEditable)
                            .fillMaxWidth()
                    )
                    ExposedDropdownMenu(
                        expanded = expandedHour,
                        onDismissRequest = { expandedHour = false }

                    ) {
                        hours.forEach { h ->
                            DropdownMenuItem(
                                text = { Text(h) },
                                onClick = {
                                    hour = h
                                    expandedHour = false
                                }
                            )
                        }
                    }
                }

            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val hourInt = hour.toIntOrNull() ?: 0
                    onConfirm(day, hourInt, title)
                }
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
