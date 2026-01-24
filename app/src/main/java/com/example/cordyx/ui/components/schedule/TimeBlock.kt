package com.example.cordyx.ui.components.schedule

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TimeBlock(hour: String, title: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxSize().clickable(onClick = onClick).padding(12.dp)

    ) {
        Text(
            text = hour,
            modifier = Modifier.width(60.dp)

        )
        Text(title)

    }
}