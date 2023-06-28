package com.jght.shipmentsassignment.presentation.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jght.shipmentsassignment.presentation.settings.viewmodel.SettingsViewModel
import com.jght.shipmentsassignment.presentation.ui.models.MyInputTextModelUI

@Composable
fun ServerConnectionWidget(
    modifier: Modifier,
    onSaveServerSettings: () -> Unit
) {

    val settingsViewModel: SettingsViewModel = viewModel()

    val supportTextIpAddress = "Enter valid IP address"
    val supportTextPortAddress = "Enter valid port"

    val ipAddress by settingsViewModel.ipAddress.observeAsState("")
    val portAddress by settingsViewModel.portAddress.observeAsState("")

    val isIpAddressValid by settingsViewModel.isIpAddressValid.observeAsState(true)
    val isPortAddressValid by settingsViewModel.isPortAddressValid.observeAsState(true)

    val ipAddressObj = MyInputTextModelUI(
        value = ipAddress,
        onValueChange = settingsViewModel::onIpAddressChange,
        isValid = isIpAddressValid,
        label = "Ip Address",
        supportingText = supportTextIpAddress
    )

    val portAddressObj = MyInputTextModelUI(
        value = portAddress,
        onValueChange = settingsViewModel::onPortAddressChange,
        isValid = isPortAddressValid,
        label = "Port Address",
        supportingText = supportTextPortAddress
    )

    ServerConnectionWidgetContent(
        modifier = modifier,
        ipAddressObj = ipAddressObj,
        portAddressObj = portAddressObj,
        onSaveServerSettings = onSaveServerSettings
    )
}

@Composable
fun ServerConnectionWidgetContent(
    modifier: Modifier,
    ipAddressObj: MyInputTextModelUI,
    portAddressObj: MyInputTextModelUI,
    onSaveServerSettings: () -> Unit
) {
    Column(
        modifier = modifier.wrapContentSize(align = Alignment.Center),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val focusManager = LocalFocusManager.current

        //Text(text = "Server Connection Setting", style = MaterialTheme.typography.titleLarge)

        ipAddressObj.apply {
            MyInputTextField(
                value = value,
                onValChange = onValueChange,
                isValid = isValid,
                modifier = modifier.wrapContentWidth(align = Alignment.CenterHorizontally),
                label = label,
                supportingText = supportingText,
                keyBoardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                imeAction = ImeAction.Next
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        portAddressObj.apply {
            MyInputTextField(
                value = value,
                onValChange = onValueChange,
                isValid = isValid,
                modifier = modifier,
                label = label,
                supportingText = supportingText,
                keyBoardActions = KeyboardActions(
                    /*onDone = { onSaveSettings }*/
                ),
                imeAction = ImeAction.Done
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onSaveServerSettings,
            modifier = Modifier
        ) {
            Text(text = "Save Server Settings")
        }
    }
}