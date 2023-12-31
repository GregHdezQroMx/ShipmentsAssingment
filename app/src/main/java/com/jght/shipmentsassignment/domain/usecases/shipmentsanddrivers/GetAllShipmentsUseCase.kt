package com.jght.shipmentsassignment.domain.usecases.shipmentsanddrivers

import com.jght.shipmentsassignment.data.ShipmentsRepository
import com.jght.shipmentsassignment.domain.models.Shipments
import com.jght.shipmentsassignment.domain.models.ShipmentsDataSourceOrigin
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class GetAllShipmentsUseCase: KoinComponent {

    private val shipmentsRepository: ShipmentsRepository by inject()

    suspend operator fun invoke(sourceOrigin: ShipmentsDataSourceOrigin): Shipments {
        return shipmentsRepository.getAllShipments(sourceOrigin)
    }
}