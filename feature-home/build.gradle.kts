@file:Suppress("UnstableApiUsage")
plugins {
    id("com.hearthstone.android-library")
    id("androidx.navigation.safeargs.kotlin")
}

android{
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(projects.coreNetworking)
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.bundles.koin)
    implementation(libs.bundles.networking)
    implementation(libs.glide)

    testImplementation(libs.bundles.test)

}