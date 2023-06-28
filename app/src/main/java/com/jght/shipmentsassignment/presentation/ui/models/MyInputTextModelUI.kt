package com.jght.shipmentsassignment.presentation.ui.models

data class MyInputTextModelUI(
    val value: String = "",
    val onValueChange: (String) -> Unit,
    val isValid: Boolean = true,
    val label: String = "",
    val supportingText: String = ""
)
