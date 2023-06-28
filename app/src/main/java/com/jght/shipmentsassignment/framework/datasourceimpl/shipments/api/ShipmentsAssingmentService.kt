package com.jght.shipmentsassignment.framework.datasourceimpl.shipments.api

import com.jght.shipmentsassignment.domain.models.Driver
import com.jght.shipmentsassignment.domain.models.Shipment
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ShipmentsAssignmentService {

    @GET("shipments.json")
    fun getAllShipments(): Flow<List<Shipment>>

    @GET("drivers.json")
    fun getAllDrivers(): Flow<List<Driver>>
}