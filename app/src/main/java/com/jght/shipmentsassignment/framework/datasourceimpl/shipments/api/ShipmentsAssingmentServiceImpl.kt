package com.jght.shipmentsassignment.framework.datasourceimpl.shipments.api

import com.jght.shipmentsassignment.domain.models.Drivers
import com.jght.shipmentsassignment.domain.models.Shipments
import retrofit2.Retrofit

class ShipmentsAssignmentServiceImpl: ShipmentsAssignmentService {

    private val retrofit: Retrofit = RetrofitHelper.getRetrofit()

    override suspend fun getAllShipments(): Shipments {
        return retrofit.create(ShipmentsAssignmentService::class.java).getAllShipments()
    }

    override suspend fun getAllDrivers(): Drivers {
        return retrofit.create(ShipmentsAssignmentService::class.java).getAllDrivers()
    }
}