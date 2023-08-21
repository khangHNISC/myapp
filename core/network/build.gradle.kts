@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("myapp.android.library")
    id("myapp.android.hilt")
}

android {
    namespace = "com.example.myapp.core.network"
}