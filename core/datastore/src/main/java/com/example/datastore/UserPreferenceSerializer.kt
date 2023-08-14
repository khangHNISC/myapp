package com.example.datastore

import androidx.datastore.core.Serializer
import com.example.myapp.core.datastore.UserPreferences
import java.io.InputStream
import java.io.OutputStream

class UserPreferenceSerializer: Serializer<UserPreferences> {
    override val defaultValue: UserPreferences
        get() = TODO("Not yet implemented")

    override suspend fun readFrom(input: InputStream): UserPreferences {
        TODO("Not yet implemented")
    }

    override suspend fun writeTo(t: UserPreferences, output: OutputStream) {
        TODO("Not yet implemented")
    }
}