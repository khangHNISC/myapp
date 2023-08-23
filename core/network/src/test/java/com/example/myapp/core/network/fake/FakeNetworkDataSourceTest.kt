package com.example.myapp.core.network.fake

import JVMUnitTestFakeAssetManager
import com.example.myapp.core.network.model.UserPresentation
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


class FakeNetworkDataSourceTest {
    private lateinit var subject: FakeNetworkDataSource

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        subject = FakeNetworkDataSource(
            ioDispatcher = testDispatcher,
            networkJson = Json { ignoreUnknownKeys = true },
            assets = JVMUnitTestFakeAssetManager
        )
    }

    @Test
    fun testDeserializeOfUsers() = runTest(testDispatcher) {
        assertEquals(
            UserPresentation(
                1, "Leanne Graham", "Sincere@april.biz", "1-770-736-8031 x56442"
            ),
            subject.getAllUsers().first()
        )
    }
}