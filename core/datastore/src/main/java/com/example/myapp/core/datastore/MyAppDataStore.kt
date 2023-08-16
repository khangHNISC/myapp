package com.example.myapp.core.datastore

import androidx.datastore.core.DataStore
import com.example.myapp.core.model.data.User
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * A Service class that handles saving and retrieving values to and from [DataStore] of [UserPreferences].
 */
class MyAppDataStore @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>,
) {
    val userData = userPreferences.data.map { User(it.shouldHideOnboarding) }
    suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) {
        userPreferences.updateData {
            it.copy {
                this.shouldHideOnboarding = shouldHideOnboarding
            }
        }
    }
}
