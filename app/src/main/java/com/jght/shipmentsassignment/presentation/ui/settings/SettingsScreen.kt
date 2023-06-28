package com.jght.shipmentsassignment.presentation.ui.settings

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jght.shipmentsassignment.presentation.settings.viewmodel.SettingsViewModel
import com.jght.shipmentsassignment.presentation.ui.widgets.DataSourceOriginWidget

@Composable
fun SettingsScreen(modifier: Modifier) {

    val settingsViewModel: SettingsViewModel = viewModel()

    val isDataSourceRemoteOriginActivated by settingsViewModel.isRemoteDataSourceOriginActivated.observeAsState(initial = false)

    settingsViewModel.getRemoteOriginActivated()

    SettingsContent(
        modifier = modifier,
        isChecked = isDataSourceRemoteOriginActivated,
        onCheckedChange = settingsViewModel::onRemoteDataSourceOriginChange,
        //TODO: Next version to connect to REST API with Local NodeJs Project
        //onSaveServerSettings = settingsViewModel::onSaveServerSettings
    )
}

@Composable
private fun SettingsContent(
    modifier: Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    //TODO: Next version to connect to REST API with Local NodeJs Project
    //onSaveServerSettings: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .animateContentSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        DataSourceOriginWidget(
            modifier = modifier,
            isChecked = isChecked,
            onCheckedChange = onCheckedChange
        )

        //TODO: Next version to connect to REST API with Local NodeJs Project
        /*if (isChecked) {
            Spacer(modifier = Modifier.height(16.dp))

            ServerConnectionWidget(
                modifier = modifier,
                onSaveServerSettings = onSaveServerSettings
            )
        }*/
    }
}

@Preview
@Composable
fun CollapsibleSectionTest() {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .animateContentSize()
            .clickable { isExpanded = !isExpanded }
    ) {
        // Content of the collapsible section
        // Replace this with your own content
        // Example: Text("Section Content")
        Row(
            modifier = Modifier.align(Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Section Title", modifier = Modifier.weight(4.0f))

            // Toggle icon based on the state
            val toggleIcon: ImageVector = if (isExpanded) {
                Icons.Filled.KeyboardArrowUp
            } else {
                Icons.Filled.KeyboardArrowDown
            }

            //Spacer(modifier = Modifier.width(16.dp))

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
            // Show the content when expanded
            // Replace this with your own content
            // Example: Text("Section Content")
            Text("Content of the collapsible section")
        }


    }
}
