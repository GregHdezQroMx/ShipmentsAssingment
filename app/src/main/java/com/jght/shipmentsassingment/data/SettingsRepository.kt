package com.jght.shipmentsassingment.data

import com.jght.shipmentsassingment.domain.models.ServerSettings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    fun saveServerSettings(serverSettings: ServerSettings)

    fun getServerSettings(): Flow<ServerSettings>
}