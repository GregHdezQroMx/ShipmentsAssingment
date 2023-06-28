package com.jght.shipmentsassignment.presentation.ui.widgets

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CollapsibleSectionWidget(
    modifier: Modifier,
    description: String,
    content: @Composable () -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    CollapsibleSectionContent(
        modifier = modifier,
        isExpanded = isExpanded,
        onClick = { isExpanded = !isExpanded },
        description,
        content
    )

}

@Composable
fun CollapsibleSectionContent(
    modifier: Modifier,
    isExpanded: Boolean,
    onClick: () -> Unit,
    description: String,
    content: @Composable () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .animateContentSize()
            .clickable { onClick() }
    ) {

        Row(
            modifier = Modifier.align(Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(description, modifier = Modifier.weight(4.0f))

            val toggleIcon: ImageVector = if (isExpanded) {
                Icons.Filled.KeyboardArrowUp
            } else {
                Icons.Filled.KeyboardArrowDown
            }

            Icon(
                imageVector = toggleIcon,
                contentDescription = "Toggle",
                modifier = Modifier
                    .weight(1.0f)
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
            )
        }

        // Colapsible section
        if (isExpanded) {
            content()
        }
    }
}
