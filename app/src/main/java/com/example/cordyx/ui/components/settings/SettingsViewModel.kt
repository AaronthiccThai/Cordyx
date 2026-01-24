package com.example.cordyx.ui.components.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SettingsViewModel: ViewModel() {
    var is24hr by mutableStateOf(true)
        private set

    fun toggleTimeFormat() {
        is24hr = !is24hr
    }
}