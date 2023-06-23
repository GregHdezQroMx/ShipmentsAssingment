package com.jght.shipmentsassingment.domain.usecases.settings

import com.jght.shipmentsassingment.data.SettingsRepository
import com.jght.shipmentsassingment.domain.models.ServerSettings
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class GetServerSettingsUseCase: KoinComponent {

    private val settingsRepository: SettingsRepository by inject()

    operator fun invoke(serverSettings: ServerSettings): Flow<ServerSettings> {

        return settingsRepository.getServerSettings()
    }
}