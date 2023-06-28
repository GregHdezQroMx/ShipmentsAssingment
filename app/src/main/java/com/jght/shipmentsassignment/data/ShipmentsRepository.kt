package com.jght.shipmentsassignment.data

import com.jght.shipmentsassignment.domain.models.Drivers
import com.jght.shipmentsassignment.domain.models.Shipments
import com.jght.shipmentsassignment.domain.models.ShipmentsDataSourceOrigin

interface ShipmentsRepository {

    suspend fun getAllShipments(source: ShipmentsDataSourceOrigin): Shipments

    suspend fun getAllDrivers(source: ShipmentsDataSourceOrigin): Drivers
}