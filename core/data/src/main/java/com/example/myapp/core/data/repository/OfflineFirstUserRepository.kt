package com.example.myapp.core.data.repository

import com.example.myapp.core.datastore.MyAppDataStore
import com.example.myapp.core.model.data.User
import kotlinx.coroutines.flow.Flow
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