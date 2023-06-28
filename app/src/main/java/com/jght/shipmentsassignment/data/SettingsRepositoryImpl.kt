package com.jght.shipmentsassignment.data

import com.jght.shipmentsassignment.domain.models.ServerSettings
import com.jght.shipmentsassignment.framework.datasourceimpl.settings.SettingsDataSource
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class SettingsRepositoryImpl: SettingsRepository, KoinComponent {

    private val settingsDataSource: SettingsDataSource by inject()
    override suspend fun saveRemoteDataSourceOrigin(isActivated: Boolean) {
        settingsDataSource.saveRemoteDataSourceOrigin(isActivated = isActivated)
    }

    override suspend fun getRemoteDataSourceOrigin(): Flow<Boolean> {
        return settingsDataSource.getRemoteDataSourceOrigin()
    }

    override suspend fun saveServerSettings(serverSettings: ServerSettings) {
        settingsDataSource.saveServerSettings(serverSettings)
    }

    override suspend fun getServerSettings(): Flow<ServerSettings> {
        return settingsDataSource.getServerSettings()
    }
}