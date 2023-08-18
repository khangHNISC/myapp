@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("myapp.android.library")
    id("myapp.android.hilt")
}

android {
    namespace = "com.example.myapp.core.data"
}

dependencies {
    implementation(libs.junit)
    implementation(libs.kotlinx.coroutines.test)

    implementation(project(":core:datastore"))
    implementation(project(":core:model"))
    implementation(project(":core:common"))

    testImplementation(project(":core:datastore-test"))
}