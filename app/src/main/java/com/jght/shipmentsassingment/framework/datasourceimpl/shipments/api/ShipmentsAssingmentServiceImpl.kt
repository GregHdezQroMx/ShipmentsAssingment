package com.jght.shipmentsassingment.framework.datasourceimpl.shipments.api

import agency.eas.entregasframmex.data.network.RetrofitHelper
import com.jght.shipmentsassingment.domain.models.Driver
import com.jght.shipmentsassingment.domain.models.Shipment
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit

class ShipmentsAssingmentServiceImpl: ShipmentsAssingmentService {

    private val retrofit: Retrofit = RetrofitHelper.getRetrofit()

    override fun getAllShipments(): Flow<List<Shipment>> {
        return retrofit.create(ShipmentsAssingmentService::class.java).getAllShipments()
    }

    override fun getAllDrivers(): Flow<List<Driver>> {
        return retrofit.create(ShipmentsAssingmentService::class.java).getAllDrivers()
    }
}