package com.jght.shipmentsassignment.domain.usecases.settings

import com.jght.shipmentsassignment.data.SettingsRepository
import com.jght.shipmentsassignment.domain.models.ServerSettings
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class SaveServerSettingsUseCase: KoinComponent {

    private val settingsRepository: SettingsRepository by inject()

    suspend operator fun invoke(serverSettings: ServerSettings) {

        settingsRepository.saveServerSettings(serverSettings = serverSettings)
    }
}