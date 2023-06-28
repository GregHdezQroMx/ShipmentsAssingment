package com.jght.shipmentsassignment.framework.di

import com.jght.shipmentsassignment.data.SettingsRepository
import com.jght.shipmentsassignment.data.SettingsRepositoryImpl
import com.jght.shipmentsassignment.data.ShipmentsRepository
import com.jght.shipmentsassignment.data.ShipmentsRepositoryImpl
import com.jght.shipmentsassignment.framework.datasourceimpl.shipments.ShipmentsApiDataSource
import com.jght.shipmentsassignment.framework.datasourceimpl.shipments.ShipmentsApiDataSourceImpl
import com.jght.shipmentsassignment.framework.datasourceimpl.shipments.ShipmentsFileDataSource
import com.jght.shipmentsassignment.framework.datasourceimpl.shipments.ShipmentsFileDataSourceImpl
import com.jght.shipmentsassignment.presentation.main.viewmodel.MainViewModel
import com.jght.shipmentsassignment.presentation.settings.viewmodel.SettingsViewModel
import com.jght.shipmentsassignment.framework.datasourceimpl.settings.SettingsDataSource
import com.jght.shipmentsassignment.framework.datasourceimpl.settings.SettingsDataSourceImpl
import com.jght.shipmentsassignment.framework.datasourceimpl.shipments.api.ShipmentsAssignmentService
import com.jght.shipmentsassignment.framework.datasourceimpl.shipments.api.ShipmentsAssignmentServiceImpl
import com.jght.shipmentsassignment.framework.preferences.PreferenceManager
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MainModule {

    val mainModule = module {

        single<ShipmentsFileDataSource> { ShipmentsFileDataSourceImpl() }

        single<ShipmentsApiDataSource> { ShipmentsApiDataSourceImpl() }

        single<SettingsDataSource> { SettingsDataSourceImpl() }

        single<ShipmentsRepository> {
            ShipmentsRepositoryImpl()
        }

        single<SettingsRepository> {
            SettingsRepositoryImpl()
        }

        single<ShipmentsAssignmentService>{
            ShipmentsAssignmentServiceImpl()
        }

        single {
            PreferenceManager()
        }

        viewModel {
            MainViewModel()
        }

        viewModel {
            SettingsViewModel()
        }
    }
}