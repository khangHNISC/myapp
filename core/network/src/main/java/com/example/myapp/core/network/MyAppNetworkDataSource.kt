package com.example.myapp.core.network

import com.example.myapp.core.network.model.UserPresentation

/**
 * network data gateway
 */
interface MyAppNetworkDataSource {

    suspend fun getAllUsers(): List<UserPresentation>
}
