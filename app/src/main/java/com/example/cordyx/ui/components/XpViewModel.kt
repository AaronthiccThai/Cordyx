package com.example.cordyx.ui.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class XpViewModel: ViewModel() {
    var questXp by mutableStateOf(XpState())
        private set

    var dailyXp by mutableStateOf(XpState())
        private set

    fun gainQuestXp(amount: Int) {
        questXp = questXp.addXp(amount)
    }

    fun gainDailyXp(amount: Int) {
        dailyXp = dailyXp.addXp(amount)
    }
    var level by mutableIntStateOf(0)
        private set

}