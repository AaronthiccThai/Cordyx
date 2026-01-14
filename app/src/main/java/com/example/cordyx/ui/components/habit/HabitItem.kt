package com.example.cordyx.ui.components.habit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// UI for showcasing each Habit probably alongside a progress bar
// In form of like a card inside ag rid
@Composable
fun HabitCard(habit: Habit, onCheckChanged: () -> Unit) {

    Row (
        modifier = Modifier
        .padding(32.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Checkbox(
            checked = habit.completed,
            onCheckedChange = { onCheckChanged() }
        )
        Text(
            text = habit.title
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HabitCardPreview() {
    var checkState by remember { mutableStateOf(false) }

    Row (
        modifier = Modifier
            .padding(32.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Checkbox(
            checked = checkState,
            onCheckedChange = { isChecked -> checkState = isChecked }
        )
        Text(
            text = "Test"
        )
    }
}