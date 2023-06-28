package com.jght.shipmentsassignment.presentation.ui.models

sealed class Routes(val route: String) {
    object ShipmentsAssignmentScreen: Routes("shipments_assignment_screen")
    object SettingsScreen: Routes("settings_screen")
    object ShipmentsAndDriversScreen: Routes("shipments_and_drivers_screen")
}