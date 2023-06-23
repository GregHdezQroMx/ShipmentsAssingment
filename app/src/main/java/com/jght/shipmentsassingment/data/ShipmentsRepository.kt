package com.jght.shipmentsassingment.data

import com.jght.shipmentsassingment.domain.models.Driver
import com.jght.shipmentsassingment.domain.models.Shipment
import com.jght.shipmentsassingment.domain.models.ShipmentsDataSourceOrigin
import kotlinx.coroutines.flow.Flow

interface ShipmentsRepository {

    fun getAllShipments(source: ShipmentsDataSourceOrigin): Flow<List<Shipment>>

    fun getAllDrivers(source: ShipmentsDataSourceOrigin): Flow<List<Driver>>
}