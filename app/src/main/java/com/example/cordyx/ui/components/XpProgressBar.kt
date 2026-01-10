package com.example.cordyx.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun XpProgressBar(currentXp: Int, xpToNextLevel: Int, level: Int, onAddXp: () -> Unit) {
    val progress = currentXp.toFloat() / xpToNextLevel
    val animatedProgress by animateFloatAsState(
        targetValue = progress.coerceIn(0f, 1f),
        label = "xp"
    )
    Column {
        Text("XP: $currentXp / $xpToNextLevel")

        Spacer(Modifier.height(8.dp))

        LinearProgressIndicator(
            progress = { animatedProgress },
            modifier = Modifier.fillMaxWidth().height(14.dp).clip(RoundedCornerShape(10.dp))
        )
        Button(onClick = onAddXp) {
            Text("+ XP")
        }


    }
}