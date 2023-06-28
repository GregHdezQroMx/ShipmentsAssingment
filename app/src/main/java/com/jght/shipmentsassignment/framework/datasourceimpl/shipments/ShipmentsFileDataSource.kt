package com.jght.shipmentsassignment.framework.datasourceimpl.shipments

import com.jght.shipmentsassignment.domain.models.Drivers
import com.jght.shipmentsassignment.domain.models.Shipments

interface ShipmentsFileDataSource {

    fun getAllShipments(): Shipments

    fun getAllDrivers(): Drivers
}