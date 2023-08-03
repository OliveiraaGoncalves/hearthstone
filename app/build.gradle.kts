plugins {
    id("com.hearthstone.application")
}
android {
    viewBinding {
        enable = true
    }
}


dependencies {
    implementation(projects.featureHome)
    implementation(projects.coreNetworking)
    implementation(libs.androidx.core)
    implementation(libs.splashscreen)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.bundles.koin)
    implementation(libs.bundles.kotlin)
    implementation(libs.bundles.androidSupport)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit.ext)
}