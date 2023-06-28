package com.jght.shipmentsassignment.presentation.application

import android.app.Application
import com.jght.shipmentsassignment.framework.di.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ShipmentsAssignmentApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidLogger()
            androidContext(this@ShipmentsAssignmentApplication)
            koin.loadModules(
                listOf(MainModule.mainModule)
            )
        }
    }
}