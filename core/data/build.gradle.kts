@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    kotlin("kapt")
}

android {
    namespace = "com.example.myapp.core.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.junit)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.kotlinx.coroutines.test)

    implementation(project(":core:datastore"))
    implementation(project(":core:model"))
    implementation(project(":core:common"))

    testImplementation(project(":core:datastore-test"))
}