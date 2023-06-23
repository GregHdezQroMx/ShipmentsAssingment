package com.jght.shipmentsassingment.ui.shipmentassign

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jght.shipmentsassingment.presentation.main.viewmodel.MainViewModel

@Composable
fun ShipmentAssignmentScreen(modifier: Modifier) {

    val mainViewModel by lazy { MainViewModel() }

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

    val suitabilityScore by mainViewModel.getSuitabilityScore(streetNames[0], driverNames[0]).collectAsState(initial = 0F)

    ShipmentAssignmentContent(
        modifier = modifier.fillMaxSize(),
        streetName = streetNames[0],
        driverName = driverNames[0],
        suitabilityScore = suitabilityScore
    )
}

@Composable
fun ShipmentAssignmentContent(
    modifier: Modifier,
    streetName: String,
    driverName: String,
    suitabilityScore: Float
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Street name: $streetName")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Driver name: $driverName")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Suitability score: $suitabilityScore")
    }
}