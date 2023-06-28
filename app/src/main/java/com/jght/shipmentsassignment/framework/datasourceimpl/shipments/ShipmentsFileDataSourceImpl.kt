package com.jght.shipmentsassignment.framework.datasourceimpl.shipments

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jght.shipmentsassignment.domain.models.Drivers
import com.jght.shipmentsassignment.domain.models.Shipments
import com.jght.shipmentsassignment.framework.datasourceimpl.shipments.utils.readJSONFromAsset
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class ShipmentsFileDataSourceImpl: ShipmentsFileDataSource, KoinComponent {


    private val context: Context by inject()
    override fun getAllShipments(): Shipments {

        val jsonShipmentsContent = readJSONFromAsset(context, "shipments.json")
        val shipments = Gson().fromJson(jsonShipmentsContent, Shipments::class.java)

        return shipments
    }

    override fun getAllDrivers(): Drivers {

        val jsonDriversContent = readJSONFromAsset(context, "drivers.json")
        val drivers = Gson().fromJson<Drivers>(jsonDriversContent, object : TypeToken<Drivers>() {}.type)
        return drivers
    }
}