package com.example.cordyx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.cordyx.ui.theme.CordyxTheme
import com.example.cordyx.ui.screens.TitleScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CordyxTheme {
                TitleScreen()
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
