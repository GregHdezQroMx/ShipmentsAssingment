package com.jght.shipmentsassignment.framework.datasourceimpl.shipments

import com.jght.shipmentsassignment.domain.models.Drivers
import com.jght.shipmentsassignment.domain.models.Shipments

interface ShipmentsApiDataSource {

    suspend fun getAllShipments(): Shipments

    suspend fun getAllDrivers(): Drivers
}