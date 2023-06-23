//import androidx.datastore.dataStoreFile
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
class PreferenceManager(): KoinComponent {

    private val context: Context by inject()
    private val Context.dataStore by preferencesDataStore(name = "shipment_assignment_preferences") //DataStore<Preferences> = context.createDataStore(name = "shipmnent_assignment_preferences")

    private object PreferencesKeys {

        val SERVER_IP_ADDRESS = stringPreferencesKey("server_ip_address")
        val SERVER_PORT_ADDRESS = stringPreferencesKey("server_port_address")
        val DATA_SOURCE_ORIGIN = stringPreferencesKey("data_source_origin")
    }

    suspend fun getServerIpAddressPreference(): String? {
        val preferences = context.dataStore.data.first()
        return preferences[PreferencesKeys.SERVER_IP_ADDRESS]
    }

    suspend fun saveServerIpPreference(value: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.SERVER_IP_ADDRESS] = value
        }
    }

    suspend fun getServerPortAddressPreference(): String? {
        val preferences = context.dataStore.data.first()
        return preferences[PreferencesKeys.SERVER_PORT_ADDRESS]
    }

    suspend fun saveServerPortAddressPreference(value: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.SERVER_PORT_ADDRESS] = value
        }
    }

    suspend fun getDataSourceOriginPreference(): String? {
        val preferences = context.dataStore.data.first()
        return preferences[PreferencesKeys.DATA_SOURCE_ORIGIN]
    }

    suspend fun saveDataSourceOriginPreference(value: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.DATA_SOURCE_ORIGIN] = value
        }
    }
}
