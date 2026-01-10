package com.example.cordyx.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cordyx.R
import com.example.cordyx.ui.components.XpProgressBar
import com.example.cordyx.ui.components.XpViewModel


@Composable
fun TitleScreen(xpViewModel: XpViewModel = viewModel()) {
    var count by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.title_app_name),
            style = MaterialTheme.typography.displayLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.tagline),
            style = MaterialTheme.typography.bodyLarge
        )
        Text("Count: $count")


        Row(
            modifier = Modifier
                .padding(32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
        }
        XpProgressBar(
            currentXp = xpViewModel.questXp.currentXp,
            xpToNextLevel = xpViewModel.questXp.xpToNextLevel,
            level = xpViewModel.level,
            onAddXp = { xpViewModel.gainQuestXp(10) }


        )
        XpProgressBar(
            currentXp = xpViewModel.dailyXp.currentXp,
            xpToNextLevel = xpViewModel.dailyXp.xpToNextLevel,
            level = xpViewModel.level,
            onAddXp = { xpViewModel.gainDailyXp(10) }
        )

    }

}


@Composable
fun PrimaryButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text)
    }

}
