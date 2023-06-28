package com.jght.shipmentsassignment.presentation.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DataSourceOriginWidget(
    modifier: Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    DataSourceOriginWidgetContent(
        modifier = modifier,
        isChecked = isChecked,
        onCheckedChange = onCheckedChange
    )

}

@Composable
fun DataSourceOriginWidgetContent(
    modifier: Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = "Active Remote Data Source origin", modifier = Modifier.weight(4.0f))

        Spacer(modifier = Modifier.height(16.dp))

        Switch(
            modifier = Modifier.weight(1.0f),
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            thumbContent = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Data Source Origin switch"
                )
            }
        )
    }
}