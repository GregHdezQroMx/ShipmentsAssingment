package com.jght.shipmentsassignment.domain.usecases.settings

import com.jght.shipmentsassignment.data.SettingsRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class GetRemoteDataSourceActivatedUseCase: KoinComponent {

    private val settingsRepository: SettingsRepository by inject()

    suspend operator fun invoke(): Flow<Boolean> {

        return settingsRepository.getRemoteDataSourceOrigin()
    }
}