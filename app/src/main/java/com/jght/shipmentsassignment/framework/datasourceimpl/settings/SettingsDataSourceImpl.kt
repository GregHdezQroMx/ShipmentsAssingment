package com.jght.shipmentsassignment.framework.datasourceimpl.settings

import com.jght.shipmentsassignment.domain.models.ServerSettings
import com.jght.shipmentsassignment.framework.preferences.PreferenceManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class SettingsDataSourceImpl: SettingsDataSource, KoinComponent {

    private val preferenceManager: PreferenceManager by inject()
    override suspend fun saveRemoteDataSourceOrigin(isActivated: Boolean) {
        preferenceManager.saveDataSourceOriginPreference(isActivated.toString())
    }

    override suspend fun getRemoteDataSourceOrigin(): Flow<Boolean> {
        return flowOf( preferenceManager.getDataSourceOriginPreference().toBoolean() )
    }

    override suspend fun saveServerSettings(serverSettings: ServerSettings) {
        preferenceManager.saveServerIpPreference(serverSettings.ipAddress)
        preferenceManager.saveServerPortAddressPreference(serverSettings.portAddress)
    }

    override suspend fun getServerSettings(): Flow<ServerSettings> {

        return flow {
            ServerSettings(
                ipAddress = preferenceManager.getServerIpAddressPreference()?: "",
                portAddress = preferenceManager.getServerPortAddressPreference()?: ""
            )
        }
    }
}