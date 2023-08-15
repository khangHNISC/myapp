package com.example.myapp.core.data.repository

import com.example.myapp.core.datastore.MyAppDataStore
import com.example.myapp.core.datastore.test.testUserPreferencesDataStore
import com.example.myapp.core.model.data.User
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder


class OfflineFirstUserRepositoryTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    private val testScope = TestScope(UnconfinedTestDispatcher())

    private lateinit var appDataStore: MyAppDataStore

    private lateinit var subject: OfflineFirstUserRepository

    @get:Rule
    val tmpFolder: TemporaryFolder = TemporaryFolder.builder().assureDeletion().build()

    @Before
    fun setup() {
        appDataStore = MyAppDataStore(
            tmpFolder.testUserPreferencesDataStore(testScope),
        )

        subject = OfflineFirstUserRepository(
            dataStore = appDataStore,
        )
    }


    @Test
    fun offlineFirstUserRepository_default_user_data_is_correct() =
        testScope.runTest {
            assertEquals(
                User(
                    shouldHideOnboarding = false,
                ),
                subject.userData.first(),
            )
        }

    @Test
    fun offlineFirstUserRepository_set_should_hide_onboarding() =
        testScope.runTest {
            subject.setShouldHideOnboarding(true)
            assertEquals(
                User(shouldHideOnboarding = true),
                subject.userData.first(),
            )
        }
}