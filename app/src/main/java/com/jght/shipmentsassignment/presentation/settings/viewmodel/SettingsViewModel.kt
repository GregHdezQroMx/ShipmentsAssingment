package com.jght.shipmentsassignment.presentation.settings.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jght.shipmentsassignment.data.SettingsRepository
import com.jght.shipmentsassignment.domain.models.ServerSettings
import com.jght.shipmentsassignment.domain.usecases.settings.GetRemoteDataSourceActivatedUseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class SettingsViewModel: ViewModel(), KoinComponent {

    private val settingsRepository: SettingsRepository by inject()
    private val getRemoteDataSourceActivatedUseCase =  GetRemoteDataSourceActivatedUseCase()

    private val _ipAddress = MutableLiveData("")
    val ipAddress: LiveData<String> = _ipAddress

    private val _portAddress = MutableLiveData("")
    val portAddress: LiveData<String> = _portAddress

    private val _isIpAddressValid = MutableLiveData(false)
    val isIpAddressValid: LiveData<Boolean> = _isIpAddressValid

    private val _isPortAddressValid = MutableLiveData(false)
    val isPortAddressValid: LiveData<Boolean> = _isPortAddressValid

    private val _isRemoteDataSourceOriginActivated = MutableLiveData(false)
    val isRemoteDataSourceOriginActivated: LiveData<Boolean> = _isRemoteDataSourceOriginActivated

    fun onIpAddressChange(ipAddress: String) {
        _ipAddress.value = ipAddress
        validateIpAddress(ipAddress)
    }

    fun onPortAddressChange(portAddress: String) {
        _portAddress.value = portAddress
        validatePortAddress(portAddress)
    }

    private fun validateIpAddress(ipAddress: String) {
        _isIpAddressValid.value = isIpAddressValid(ipAddress)
    }

    private fun validatePortAddress(portAddress: String) {
        _isPortAddressValid.value = isPortAddressValid(portAddress)
    }

    private fun isIpAddressValid(ipAddress: String): Boolean {

        val regex = Regex("""^((\d{1,2}|1\d{2}|2[0-4]\d|25[0-5])\.){3}(\d{1,2}|1\d{2}|2[0-4]\d|25[0-5])$""")
        return regex.matches(ipAddress)
    }

    private fun isPortAddressValid(portAddress: String): Boolean {

        val regex = Regex("""^(?:[1-9]\d{0,3}|[1-5]\d{4}|6[0-4]\d{3}|65[0-4]\d{2}|655[0-2]\d|6553[0-5])$""")
        return regex.matches(portAddress)
    }

    fun getRemoteOriginActivated() {
        viewModelScope.launch {
            getRemoteDataSourceActivatedUseCase.invoke().collect{ active ->
                _isRemoteDataSourceOriginActivated.value = active
            }
        }
    }

    fun onRemoteDataSourceOriginChange(isActivated: Boolean) {
        _isRemoteDataSourceOriginActivated.value = isActivated
        onSaveRemoteDataSourceOrigin(isActivated)
    }

    private fun onSaveRemoteDataSourceOrigin(isActivated: Boolean) {

        viewModelScope.launch {
            settingsRepository.saveRemoteDataSourceOrigin(isActivated = isActivated)
        }
    }

    fun onSaveServerSettings() {

        viewModelScope.launch {

            settingsRepository.saveServerSettings(
                ServerSettings(
                    ipAddress = ipAddress.value?:"",
                    portAddress = portAddress.value?:""
                )
            )
        }
    }
}