package com.jght.shipmentsassignment.presentation.shipmentsassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jght.shipmentsassignment.domain.models.Drivers
import com.jght.shipmentsassignment.domain.models.Shipments
import com.jght.shipmentsassignment.domain.models.ShipmentsDataSourceOrigin
import com.jght.shipmentsassignment.domain.usecases.shipmentsanddrivers.GetAllDriversUseCase
import com.jght.shipmentsassignment.domain.usecases.shipmentsanddrivers.GetAllShipmentsUseCase
import com.jght.shipmentsassignment.domain.usecases.shipmentsasignment.GetSuitabilityScoreUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class ShipmentsAssignmentViewModel: ViewModel() {

    private val getAllShipmentsUseCase by lazy {
        GetAllShipmentsUseCase()
    }

    private val getAllDriversUseCase by lazy {
        GetAllDriversUseCase()
    }

    private val getSuitabilityScoreUseCase by lazy {
        GetSuitabilityScoreUseCase()
    }

    private val _shipments =  MutableLiveData<Shipments>()
    val shipments: LiveData<Shipments> = _shipments

    private val _drivers = MutableLiveData<Drivers>()
    val drivers: LiveData<Drivers> = _drivers

    fun getAllShipments(sourceOrigin: ShipmentsDataSourceOrigin) {

         viewModelScope.launch {
            _shipments.value =  getAllShipmentsUseCase.invoke(sourceOrigin)
        }
    }

    fun getAllDrivers(sourceOrigin: ShipmentsDataSourceOrigin) {
        viewModelScope.launch {
            _drivers.value = getAllDriversUseCase.invoke(sourceOrigin)
        }
    }

    fun getSuitabilityScore(address: String, driverName: String): Flow<Float> {
        return flowOf( getSuitabilityScoreUseCase.invoke(streetName = address, driverName = driverName))
    }
}