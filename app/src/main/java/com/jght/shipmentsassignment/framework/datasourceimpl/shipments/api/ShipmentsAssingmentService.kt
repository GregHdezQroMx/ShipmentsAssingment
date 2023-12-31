package com.jght.shipmentsassignment.framework.datasourceimpl.shipments.api

import com.jght.shipmentsassignment.domain.models.Drivers
import com.jght.shipmentsassignment.domain.models.Shipments
import retrofit2.http.GET

interface ShipmentsAssignmentService {

    @GET("shipments.json")
    suspend fun getAllShipments(): Shipments

    @GET("drivers.json")
    suspend fun getAllDrivers(): Drivers
}