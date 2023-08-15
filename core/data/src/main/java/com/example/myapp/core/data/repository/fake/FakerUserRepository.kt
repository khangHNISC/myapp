package com.example.myapp.core.data.repository.fake

import com.example.myapp.core.datastore.MyAppDataStore
import com.example.myapp.core.data.repository.UserRepository
import com.example.myapp.core.model.data.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FakerUserRepository @Inject constructor(
    private val dataStore: MyAppDataStore
) : UserRepository {
    override val userData: Flow<User>
        get() = dataStore.userData

    override suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) {
        dataStore.setShouldHideOnboarding(shouldHideOnboarding)
    }
}