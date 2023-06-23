package com.jght.shipmentsassingment.framework.datasourceimpl.shipments

import android.content.Context
import com.jght.shipmentsassingment.domain.models.Driver
import com.jght.shipmentsassingment.domain.models.Shipment
import com.jght.shipmentsassingment.framework.datasourceimpl.shipments.utils.JsonParser
import com.jght.shipmentsassingment.framework.datasourceimpl.shipments.utils.readJSONFromAsset
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class ShipmentsFileDataSourceImpl: ShipmentsFileDataSource, KoinComponent {


    private val context: Context by inject()
    override fun getAllShipments(): Flow<List<Shipment>> {

        val jsonShipmentsContent = readJSONFromAsset(context, "shipments.json")
        val shipmentsParser = JsonParser<Shipment>()
        return flowOf( shipmentsParser.parseList(jsonShipmentsContent) )
    }

    override fun getAllDrivers(): Flow<List<Driver>> {

        val jsonDriversContent = readJSONFromAsset(context, "drivers.json")
        val driversParser = JsonParser<Driver>()
        return flowOf( driversParser.parseList(jsonDriversContent) )
    }
}