plugins {
    id("com.hearthstone.android-library")
}

android {
    buildTypes {
        getByName("debug") {
            buildConfigField("String", "HOST", Config.BuildField.host_release)
            buildConfigField("String", "X_RAPIDAPI_KEY", Config.BuildField.x_rapidAPI_key)
            buildConfigField("String", "X_RAPIDAPI_HOST", Config.BuildField.x_rapidAPI_host)
        }
        getByName("release") {
            buildConfigField("String", "HOST", Config.BuildField.host_release)
            buildConfigField("String", "X_RAPIDAPI_KEY", Config.BuildField.x_rapidAPI_key)
            buildConfigField("String", "X_RAPIDAPI_HOST", Config.BuildField.x_rapidAPI_host)
        }
    }
}

dependencies {
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.bundles.kotlin)
    implementation(libs.bundles.networking)
    implementation(libs.bundles.koin)
    testImplementation(libs.junit)
}