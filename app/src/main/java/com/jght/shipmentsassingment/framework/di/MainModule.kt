package com.jght.shipmentsassingment.framework.di

import com.jght.shipmentsassingment.data.SettingsRepository
import com.jght.shipmentsassingment.data.SettingsRepositoryImpl
import com.jght.shipmentsassingment.data.ShipmentsRepository
import com.jght.shipmentsassingment.data.ShipmentsRepositoryImpl
import com.jght.shipmentsassingment.framework.datasourceimpl.shipments.ShipmentsApiDataSource
import com.jght.shipmentsassingment.framework.datasourceimpl.shipments.ShipmentsApiDataSourceImpl
import com.jght.shipmentsassingment.framework.datasourceimpl.shipments.ShipmentsFileDataSource
import com.jght.shipmentsassingment.framework.datasourceimpl.shipments.ShipmentsFileDataSourceImpl
import com.jght.shipmentsassingment.presentation.main.viewmodel.MainViewModel
import com.jght.shipmentsassingment.presentation.serverconfig.viewmodel.ServerConfigViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MainModule {

    val mainModule = module {

        single<ShipmentsFileDataSource> { ShipmentsFileDataSourceImpl() }

        single<ShipmentsApiDataSource> { ShipmentsApiDataSourceImpl() }

        single<ShipmentsRepository> {
            ShipmentsRepositoryImpl()
        }

        single<SettingsRepository> {
            SettingsRepositoryImpl()
        }

        viewModel {
            MainViewModel()
        }

        viewModel {
            ServerConfigViewModel()
        }
    }
}