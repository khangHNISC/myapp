package com.example.myapp.core.network.di

import com.example.myapp.core.network.MyAppNetworkDataSource
import com.example.myapp.core.network.fake.FakeNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface FlavoredNetworkModule {

    @Binds
    fun FakeNetworkDataSource.binds(): MyAppNetworkDataSource
}
