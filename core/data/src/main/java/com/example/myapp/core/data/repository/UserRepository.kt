package com.example.myapp.core.data.repository

import com.example.myapp.core.model.data.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    /**
     * Stream of [User]
     */
    val userData: Flow<User>

    /**
     * Sets whether the user has completed the onboarding process.
     */
    suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean)
}
