package com.example.cordyx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.cordyx.ui.components.xp.XpViewModel
import com.example.cordyx.ui.theme.CordyxTheme
import com.example.cordyx.ui.screens.TitleScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CordyxTheme {
                val xpViewModel: XpViewModel = XpViewModel()
                TitleScreen(xpViewModel)

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    CordyxTheme {
        TitleScreen()
    }
}
