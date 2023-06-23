package com.jght.shipmentsassingment.presentation.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.jght.shipmentsassingment.ui.configurations.ServerConnectionScreen
import com.jght.shipmentsassingment.ui.theme.ShipmentsAssingmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShipmentsAssingmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MainContent(modifier = Modifier)
                    ServerConnectionScreen(modifier = Modifier)
                }
            }
        }
    }
}
