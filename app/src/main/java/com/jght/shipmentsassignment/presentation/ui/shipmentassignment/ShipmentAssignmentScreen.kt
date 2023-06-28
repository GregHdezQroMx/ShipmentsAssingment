package com.jght.shipmentsassignment.presentation.ui.shipmentassignment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jght.shipmentsAssignment.R
import com.jght.shipmentsassignment.presentation.settings.viewmodel.SettingsViewModel
import com.jght.shipmentsassignment.presentation.shipmentsassignment.viewmodel.ShipmentsAssignmentViewModel
import org.koin.core.component.KoinApiExtension

@OptIn(KoinApiExtension::class)
@Composable
fun ShipmentAssignmentScreen(modifier: Modifier) {

    val shipmentsAssignmentViewModel by lazy { ShipmentsAssignmentViewModel() }
    val context = LocalContext.current

    val settingsViewModel: SettingsViewModel = viewModel()
    settingsViewModel.getRemoteOriginActivated()

    val isDataSourceRemoteOriginActivated by settingsViewModel.isRemoteDataSourceOriginActivated.observeAsState(initial = false)
    val dataSourceOriginText = if (isDataSourceRemoteOriginActivated) {
        context.resources.getText(R.string.data_source_remote_origin_text).toString()
    } else {
        context.resources.getText(R.string.data_source_local_origin_text).toString()
    }

    val streetNames = listOf(
        "Osinski Manors",
        "Marvin Stravenue",
        "Kathlyn Ferry",
        "Champlin Lake",
        "Volkman Garden Suite",
        "Dessie Lights",
        "Lindgren Corners",
        "Aufderhar Rive",
        "Fake St",
    )

    val driverNames = listOf(
        "Everardo Welch",
        "Orval Mayert",
        "Howard Emmerich",
        "Izaiah Lowe",
        "Monica Hermann",
        "Ellis Wisozk",
        "Noemie Murphy",
        "Cleve Durgan",
        "Murphy Mosciski",
        "Kaiser Sos"
    )

    val suitabilityScore by shipmentsAssignmentViewModel.getSuitabilityScore(streetNames[0], driverNames[0]).collectAsState(initial = 0F)

    ShipmentAssignmentContent(
        modifier = modifier.fillMaxSize(),
        streetName = streetNames[0],
        driverName = driverNames[0],
        suitabilityScore = suitabilityScore,
        dataSourceOriginText = dataSourceOriginText
    )
}

@Composable
fun ShipmentAssignmentContent(
    modifier: Modifier,
    dataSourceOriginText: String,
    streetName: String,
    driverName: String,
    suitabilityScore: Float
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = dataSourceOriginText,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(32.dp))

        Text("Street name: $streetName")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Driver name: $driverName")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Suitability score: $suitabilityScore")
    }
}