package com.jght.shipmentsassignment.presentation.ui.shipmentsanddrivers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jght.shipmentsAssignment.R
import com.jght.shipmentsassignment.domain.models.Driver
import com.jght.shipmentsassignment.domain.models.Drivers
import com.jght.shipmentsassignment.domain.models.Shipment
import com.jght.shipmentsassignment.domain.models.Shipments
import com.jght.shipmentsassignment.domain.models.ShipmentsDataSourceOrigin
import com.jght.shipmentsassignment.presentation.settings.viewmodel.SettingsViewModel
import com.jght.shipmentsassignment.presentation.shipmentsassignment.viewmodel.ShipmentsAssignmentViewModel

@Composable
fun ShipmentsAndDriversScreen(modifier: Modifier) {

    val context = LocalContext.current
    val shipmentsAssignmentViewModel: ShipmentsAssignmentViewModel = viewModel()
    val settingsViewModel: SettingsViewModel = viewModel()

    val isDataSourceRemoteOriginActivated by settingsViewModel.isRemoteDataSourceOriginActivated.observeAsState(
        initial = false
    )

    settingsViewModel.getRemoteOriginActivated()

    val shipmentsDataSourceOrigin: ShipmentsDataSourceOrigin =
        if (isDataSourceRemoteOriginActivated) {
            ShipmentsDataSourceOrigin.Remote
        } else {
            ShipmentsDataSourceOrigin.Local
        }
    val dataSourceOriginText = if (isDataSourceRemoteOriginActivated) {
        context.resources.getText(R.string.data_source_remote_origin_text).toString()
    } else {
        context.resources.getText(R.string.data_source_local_origin_text).toString()
    }

    shipmentsAssignmentViewModel.getAllShipments(shipmentsDataSourceOrigin)
    val shipments by shipmentsAssignmentViewModel.shipments.observeAsState()

    shipmentsAssignmentViewModel.getAllDrivers(shipmentsDataSourceOrigin)
    val drivers by shipmentsAssignmentViewModel.drivers.observeAsState()

    shipments?.let {
        drivers?.let { drivers   ->
            ShipmentsAndDriversContent(
                modifier = modifier,
                dataSourceOriginText = dataSourceOriginText,
                shipments = it,
                drivers = drivers
            )
        }
    }
}

@Composable
fun ShipmentsAndDriversContent(
    modifier: Modifier,
    dataSourceOriginText: String,
    shipments: Shipments,
    drivers: Drivers
) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = "Shipments And Drivers Content")

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = dataSourceOriginText,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(text = "Streets", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                LazyColumn {
                    items(shipments.shipmentList) { shipment ->
                        ShipmentItem(shipment)
                    }
                }
            }

            Column {
                Text(text = "Drivers", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                LazyColumn {
                    items(drivers.driverList) { driver ->
                        DriverItem(driver)
                    }
                }
            }
        }
    }
}

@Composable
fun ShipmentItem(shipment: Shipment) {

    Column {

        Text(text = shipment.streetName)
    }
}

@Composable
fun DriverItem(driver: Driver) {

    Column {

        Text(text = driver.driverName)
    }
}