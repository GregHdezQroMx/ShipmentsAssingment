package com.jght.shipmentsassingment.data

import com.jght.shipmentsassingment.domain.models.ServerSettings
import kotlinx.coroutines.flow.Flow

class SettingsRepositoryImpl: SettingsRepository {

    override fun saveServerSettings(serverSettings: ServerSettings) {
        TODO("Not yet implemented")
    }

    override fun getServerSettings(): Flow<ServerSettings> {
        TODO("Not yet implemented")
    }
}