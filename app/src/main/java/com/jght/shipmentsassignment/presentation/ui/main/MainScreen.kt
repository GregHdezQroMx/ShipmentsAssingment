package com.jght.shipmentsassignment.presentation.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jght.shipmentsassignment.presentation.main.viewmodel.MainViewModel
import com.jght.shipmentsassignment.presentation.ui.models.Routes
import com.jght.shipmentsassignment.presentation.ui.settings.SettingsScreen
import com.jght.shipmentsassignment.presentation.ui.shipmentassignment.ShipmentAssignmentScreen
import com.jght.shipmentsassignment.presentation.ui.shipmentsanddrivers.ShipmentsAndDriversScreen

@Composable
fun MainScreen(modifier: Modifier) {

    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        modifier = modifier,
        topBar = { TopBarContent(modifier = modifier) },
        content = { paddingValues ->
            Box(
                modifier = Modifier.padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
            ) {
                MainContent(
                    modifier = modifier,
                    navController = navController
                )
            }
        },
        bottomBar = {
            navController.currentBackStackEntry?.let { BottomNavigationContent(navController = navController, navBackStackEntry = it) }
        },
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarContent(modifier: Modifier) {

    TopAppBar(
        title = {
            Text(text = "Shipments Assignment", modifier = modifier, textAlign = TextAlign.Center)
        },
        modifier = modifier
            .padding(horizontal = 16.dp),
    )
}

@Composable
fun MainContent(
    modifier: Modifier,
    navController: NavHostController
) {

    val mainViewModel: MainViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.ShipmentsAssignmentScreen.route
    ) {

        composable(Routes.ShipmentsAssignmentScreen.route) {
            ShipmentAssignmentScreen(
                modifier = modifier
            )
        }

        composable(Routes.ShipmentsAndDriversScreen.route) {
            ShipmentsAndDriversScreen(
                modifier = modifier
            )
        }

        composable(Routes.SettingsScreen.route) {
            SettingsScreen(
                modifier = modifier
            )
        }
    }
}

@Composable
fun BottomNavigationContent(navController: NavHostController, navBackStackEntry: NavBackStackEntry) {

    val currentDestination = navBackStackEntry.destination

    NavigationBar {
        NavigationBarItem(
            selected = currentDestination.hierarchy.any { it.route == Routes.ShipmentsAssignmentScreen.route },
            onClick = { navController.navigate(Routes.ShipmentsAssignmentScreen.route) },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "home")
            }
        )

        NavigationBarItem(
            selected = currentDestination.hierarchy.any { it.route == Routes.ShipmentsAndDriversScreen.route },
            onClick = { navController.navigate(Routes.ShipmentsAndDriversScreen.route) },
            icon = {
                Icon(imageVector = Icons.Default.List, contentDescription = "list")
            }
        )

        NavigationBarItem(
            selected = currentDestination.hierarchy.any { it.route == Routes.SettingsScreen.route },
            onClick = { navController.navigate(Routes.SettingsScreen.route) },
            icon = {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "setting")
            }
        )

    }
}