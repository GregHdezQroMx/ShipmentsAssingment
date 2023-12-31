package com.jght.shipmentsassignment.domain.usecases.settings

import com.jght.shipmentsassignment.data.SettingsRepository
import com.jght.shipmentsassignment.domain.models.ServerSettings
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class GetServerSettingsUseCase: KoinComponent {

    private val settingsRepository: SettingsRepository by inject()

    suspend operator fun invoke(): Flow<ServerSettings> {

        return settingsRepository.getServerSettings()
    }
}