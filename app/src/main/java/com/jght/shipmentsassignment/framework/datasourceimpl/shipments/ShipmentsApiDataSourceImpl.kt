package com.jght.shipmentsassignment.framework.datasourceimpl.shipments

import com.jght.shipmentsassignment.domain.models.Drivers
import com.jght.shipmentsassignment.domain.models.Shipments
import com.jght.shipmentsassignment.framework.datasourceimpl.shipments.api.ShipmentsAssignmentService
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class ShipmentsApiDataSourceImpl: ShipmentsApiDataSource, KoinComponent {

    private val shipmentsAssignmentService: ShipmentsAssignmentService by inject()
    override suspend fun getAllShipments(): Shipments {

        return shipmentsAssignmentService.getAllShipments()
    }

    override suspend fun getAllDrivers(): Drivers {

        return shipmentsAssignmentService.getAllDrivers()
    }
}