package com.jght.shipmentsassingment.framework.datasourceimpl.shipments

import com.jght.shipmentsassingment.domain.models.Driver
import com.jght.shipmentsassingment.domain.models.Shipment
import kotlinx.coroutines.flow.Flow

interface ShipmentsFileDataSource {

    fun getAllShipments(): Flow<List<Shipment>>

    fun getAllDrivers(): Flow<List<Driver>>
}