@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("myapp.android.library")
    id("myapp.android.hilt")
}

android {
    namespace = "com.example.myapp.core.datastore.test"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:datastore"))

    implementation(libs.hilt.android.testing)
    api(libs.androidx.dataStore.core)                  //data module using this dependency, expose it for testing
}