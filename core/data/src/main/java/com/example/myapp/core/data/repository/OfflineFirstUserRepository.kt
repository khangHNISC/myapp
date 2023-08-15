package com.example.myapp.core.data.repository

import com.example.datastore.MyAppDataStore
import com.example.myapp.core.model.data.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstUserRepository @Inject constructor(
    private val dataStore: MyAppDataStore
) : UserRepository {
    override val userData: Flow<User>
        get() = dataStore.userData

    override suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) {
        dataStore.setShouldHideOnboarding(shouldHideOnboarding)
    }
}