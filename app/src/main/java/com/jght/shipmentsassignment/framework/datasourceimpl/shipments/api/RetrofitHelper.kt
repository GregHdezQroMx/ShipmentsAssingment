package com.jght.shipmentsassignment.framework.datasourceimpl.shipments.api

import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(KoinApiExtension::class)
object RetrofitHelper: KoinComponent {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/GregHdezQroMx/ShipmentAssignmentApi/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}