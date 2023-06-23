package com.jght.shipmentsassingment.presentation.main.viewmodel

import androidx.lifecycle.ViewModel
import com.jght.shipmentsassingment.domain.models.Driver
import com.jght.shipmentsassingment.domain.models.Shipment
import com.jght.shipmentsassingment.domain.models.ShipmentsDataSourceOrigin
import com.jght.shipmentsassingment.domain.usecases.shipmentsasignment.GetAllDriversUseCase
import com.jght.shipmentsassingment.domain.usecases.shipmentsasignment.GetAllShipmentsUseCase
import com.jght.shipmentsassingment.domain.usecases.shipmentsasignment.GetSuitabilityScoreUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MainViewModel: ViewModel() {

    private val GetAllShipmentsUseCase by lazy {
        GetAllShipmentsUseCase()
    }

    private val GetAllDriversUseCase by lazy {
        GetAllDriversUseCase()
    }

    private val getSuitabilityScoreUseCase by lazy {
        GetSuitabilityScoreUseCase()
    }

    fun getAllShipments(sourceOrigin: ShipmentsDataSourceOrigin): Flow<List<Shipment>> {
        return GetAllShipmentsUseCase.invoke(sourceOrigin)
    }

    fun getAllDrivers(sourceOrigin: ShipmentsDataSourceOrigin): Flow<List<Driver>> {
        return GetAllDriversUseCase.invoke(sourceOrigin)
    }

    fun getSuitabilityScore(address: String, driverName: String): Flow<Float> {
        return flowOf( getSuitabilityScoreUseCase.invoke(streetName = address, driverName = driverName))
    }
}