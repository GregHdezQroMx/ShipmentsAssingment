package com.jght.shipmentsassignment.framework.datasourceimpl.settings

import com.jght.shipmentsassignment.domain.models.ServerSettings
import kotlinx.coroutines.flow.Flow

interface SettingsDataSource {

    suspend fun saveRemoteDataSourceOrigin(isActivated: Boolean)

    suspend fun getRemoteDataSourceOrigin(): Flow<Boolean>

    suspend fun saveServerSettings(serverSettings: ServerSettings)

    suspend fun getServerSettings(): Flow<ServerSettings>
}