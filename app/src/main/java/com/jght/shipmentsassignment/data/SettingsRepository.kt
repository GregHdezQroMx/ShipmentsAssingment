package com.jght.shipmentsassignment.data

import com.jght.shipmentsassignment.domain.models.ServerSettings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    suspend fun saveRemoteDataSourceOrigin(isActivated: Boolean)

    suspend fun getRemoteDataSourceOrigin(): Flow<Boolean>

    suspend fun saveServerSettings(serverSettings: ServerSettings)

    suspend fun getServerSettings(): Flow<ServerSettings>
}