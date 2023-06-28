package com.jght.shipmentsassignment.data

import com.jght.shipmentsassignment.domain.models.Drivers
import com.jght.shipmentsassignment.domain.models.Shipments
import com.jght.shipmentsassignment.domain.models.ShipmentsDataSourceOrigin
import com.jght.shipmentsassignment.framework.datasourceimpl.shipments.ShipmentsApiDataSource
import com.jght.shipmentsassignment.framework.datasourceimpl.shipments.ShipmentsFileDataSource
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class ShipmentsRepositoryImpl: ShipmentsRepository, KoinComponent {

    private val shipmentsFileDataSource: ShipmentsFileDataSource by inject()
    private val shipmentsApiDataSource: ShipmentsApiDataSource by inject()

    override suspend fun getAllShipments(source: ShipmentsDataSourceOrigin): Shipments {

        return when (source) {
            ShipmentsDataSourceOrigin.Local -> {
                shipmentsFileDataSource.getAllShipments()
            }
            ShipmentsDataSourceOrigin.Remote -> {
                shipmentsApiDataSource.getAllShipments()
            }
        }
    }

    override suspend fun getAllDrivers(source: ShipmentsDataSourceOrigin): Drivers {

        return when (source) {
            ShipmentsDataSourceOrigin.Local -> {
                shipmentsFileDataSource.getAllDrivers()
            }
            ShipmentsDataSourceOrigin.Remote -> {
                shipmentsApiDataSource.getAllDrivers()
            }
        }
    }
}