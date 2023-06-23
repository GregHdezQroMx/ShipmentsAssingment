package com.jght.shipmentsassingment.ui.main

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier) {
    
    Scaffold(
        modifier = modifier,
        topBar = { },
        content = { MainContent() },
        bottomBar = { },
    )
}

@Composable
fun MainContent() {

}