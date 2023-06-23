package com.jght.shipmentsassingment.ui.configurations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import com.jght.shipmentsassingment.presentation.serverconfig.viewmodel.ServerConfigViewModel
import com.jght.util.mixcalcbicomponent.framework.presentation.main.view.ui.models.MyInputTextModelUI
import com.jght.util.mixcalcbicomponent.framework.presentation.main.view.ui.widgets.MyInputTextField

@Composable
fun ServerConnectionScreen(
    modifier: Modifier
) {

    val serverConfigViewModel: ServerConfigViewModel = viewModel()

    val supportTextIpAddress = "Enter valid IP address"
    val supportTextPortAddress = "Enter valid port"

    val ipAddress by serverConfigViewModel.ipAddress.observeAsState("")
    val portAddress by serverConfigViewModel.portAddress.observeAsState("")

    val isIpAddressValid by serverConfigViewModel.isIpAddressValid.observeAsState(true)
    val isPortAddressValid by serverConfigViewModel.isPortAddressValid.observeAsState(true)

    val ipAddressObj = MyInputTextModelUI(
        value = ipAddress,
        onValueChange = serverConfigViewModel::onIpAddressChange,
        isValid = isIpAddressValid,
        label = "Ip Address",
        supportingText = supportTextIpAddress
    )

    val portAddressObj = MyInputTextModelUI(
        value = portAddress,
        onValueChange = serverConfigViewModel::onPortAddressChange,
        isValid = isPortAddressValid,
        label = "Port Address",
        supportingText = supportTextPortAddress
    )

    ServerConnectionContent(
        modifier = modifier,
        ipAddressObj = ipAddressObj,
        portAddressObj = portAddressObj,
        onSaveSettings = serverConfigViewModel::onSaveSettings
    )
}

@Composable
fun ServerConnectionContent(
    modifier: Modifier,
    ipAddressObj: MyInputTextModelUI,
    portAddressObj: MyInputTextModelUI,
    onSaveSettings: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val focusManager = LocalFocusManager.current

        Text(text = "Server Connection Setting", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(32.dp))

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
                    onDone = { onSaveSettings }
                ),
                imeAction = ImeAction.Done
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onSaveSettings,
            modifier = Modifier
        ) {
            Text(text = "Save Settings")
        }
    }

}