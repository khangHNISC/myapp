package com.example.myapp.core.network.model

import kotlinx.serialization.Serializable

/**
 * network representation of an User
 */
@Serializable
data class UserPresentation(
    val id: Long,
    val name: String = "",
    val email: String,
    val phone: String,
)
