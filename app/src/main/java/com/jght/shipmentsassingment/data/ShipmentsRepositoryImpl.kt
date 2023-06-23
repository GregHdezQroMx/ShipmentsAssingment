package com.jght.shipmentsassingment.data

import com.jght.shipmentsassingment.domain.models.Driver
import com.jght.shipmentsassingment.domain.models.Shipment
import com.jght.shipmentsassingment.domain.models.ShipmentsDataSourceOrigin
import com.jght.shipmentsassingment.framework.datasourceimpl.shipments.ShipmentsApiDataSource
import com.jght.shipmentsassingment.framework.datasourceimpl.shipments.ShipmentsFileDataSource
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class ShipmentsRepositoryImpl: ShipmentsRepository, KoinComponent {

    private val shipmentsFileDataSource: ShipmentsFileDataSource by inject()
    private val shipmentsApiDataSource: ShipmentsApiDataSource by inject()

    override fun getAllShipments(source: ShipmentsDataSourceOrigin): Flow<List<Shipment>> {

        return when (source) {
            ShipmentsDataSourceOrigin.Local -> {
                shipmentsFileDataSource.getAllShipments()
            }
            ShipmentsDataSourceOrigin.Remote -> {
                shipmentsApiDataSource.getAllShipments()
            }
        }
    }

    override fun getAllDrivers(source: ShipmentsDataSourceOrigin): Flow<List<Driver>> {

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