package com.example.myapp.core.data.di

import com.example.myapp.core.data.repository.OfflineFirstUserRepository
import com.example.myapp.core.data.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsUserRepository(
        userDataRepository: OfflineFirstUserRepository,
    ): UserRepository
}