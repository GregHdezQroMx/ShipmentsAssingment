package com.jght.shipmentsassignment.framework.datasourceimpl.shipments.api

import agency.eas.entregasframmex.data.network.RetrofitHelper
import com.jght.shipmentsassignment.domain.models.Driver
import com.jght.shipmentsassignment.domain.models.Shipment
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit

class ShipmentsAssignmentServiceImpl: ShipmentsAssignmentService {

    private val retrofit: Retrofit = RetrofitHelper.getRetrofit()

    override fun getAllShipments(): Flow<List<Shipment>> {
        return retrofit.create(ShipmentsAssignmentService::class.java).getAllShipments()
    }

    override fun getAllDrivers(): Flow<List<Driver>> {
        return retrofit.create(ShipmentsAssignmentService::class.java).getAllDrivers()
    }
}