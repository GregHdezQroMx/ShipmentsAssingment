package com.jght.shipmentsassingment.framework.datasourceimpl.shipments.api

import com.jght.shipmentsassingment.domain.models.Driver
import com.jght.shipmentsassingment.domain.models.Shipment
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ShipmentsAssingmentService {

    @GET("shipments.json")
    fun getAllShipments(): Flow<List<Shipment>>

    @GET("drivers.json")
    fun getAllDrivers(): Flow<List<Driver>>
}