@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("myapp.android.library")
    id("myapp.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.myapp.core.network"

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    testImplementation(libs.kotlinx.coroutines.test)

    implementation(project(":core:common"))
}