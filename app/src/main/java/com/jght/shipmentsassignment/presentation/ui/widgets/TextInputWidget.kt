package com.jght.shipmentsassignment.presentation.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyInputTextField(
    value: String,
    onValChange: (String) -> Unit,
    isValid: Boolean,
    modifier: Modifier,
    label: String = "",
    supportingText: String = "",
    keyBoardActions: KeyboardActions,
    imeAction: ImeAction,
) {

    Column(
        modifier = modifier.padding(16.dp),
    ) {

        OutlinedTextField(
            value = value,
            onValueChange = onValChange,
            modifier = modifier.wrapContentHeight(),
            label = { Text(text = label, style = MaterialTheme.typography.labelSmall) },
            isError = !isValid,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
                unfocusedBorderColor = Color.Blue,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = imeAction ),
            keyboardActions = keyBoardActions,
            singleLine = true
        )

        val errorText = if (!isValid) supportingText else ""

        Text(
            text = errorText,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.error,
            modifier = modifier
                .wrapContentHeight()
                .padding(top = 4.dp),
        )
    }
}