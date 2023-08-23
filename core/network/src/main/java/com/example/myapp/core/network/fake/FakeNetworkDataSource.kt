package com.example.myapp.core.network.fake

import JVMUnitTestFakeAssetManager
import com.example.myapp.core.common.network.AppDispatchers
import com.example.myapp.core.common.network.Dispatcher
import com.example.myapp.core.network.MyAppNetworkDataSource
import com.example.myapp.core.network.model.UserPresentation
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject

class FakeNetworkDataSource @Inject constructor(
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val networkJson: Json,
    private val assets: FakeAssetManager = JVMUnitTestFakeAssetManager,
) : MyAppNetworkDataSource {
    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getAllUsers(): List<UserPresentation> =
        withContext(ioDispatcher) {
            assets.open(USERS_ASSET).use(networkJson::decodeFromStream)
        }

    companion object {
        private const val USERS_ASSET = "users.json"
    }
}