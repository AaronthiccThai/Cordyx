package com.example.cordyx.ui.components.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(settingsViewModel: SettingsViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Time Format")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(if (settingsViewModel.is24hr) "24-hour" else "12-hour")
            Switch(
                checked = settingsViewModel.is24hr,
                onCheckedChange = { settingsViewModel.toggleTimeFormat() }
            )
        }
    }
}
