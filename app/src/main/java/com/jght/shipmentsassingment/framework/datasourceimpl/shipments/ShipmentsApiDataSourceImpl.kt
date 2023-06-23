package com.jght.shipmentsassingment.framework.datasourceimpl.shipments

import com.jght.shipmentsassingment.domain.models.Driver
import com.jght.shipmentsassingment.domain.models.Shipment
import kotlinx.coroutines.flow.Flow

class ShipmentsApiDataSourceImpl: ShipmentsApiDataSource {

    override fun getAllShipments(): Flow<List<Shipment>> {
        TODO("Not yet implemented")
    }

    override fun getAllDrivers(): Flow<List<Driver>> {
        TODO("Not yet implemented")
    }
}