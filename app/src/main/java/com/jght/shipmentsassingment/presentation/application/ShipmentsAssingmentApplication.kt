package com.jght.shipmentsassingment.presentation.application

import android.app.Application
import com.jght.shipmentsassingment.framework.di.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ShipmentsAssingmentApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidLogger()
            androidContext(this@ShipmentsAssingmentApplication)
            koin.loadModules(
                listOf(MainModule.mainModule)
            )
        }
    }
}