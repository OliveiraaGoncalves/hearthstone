
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.hearthstone.application")
}
android {
    viewBinding {
        enable = true
    }
}


dependencies {
    implementation(project(":feature-home"))
    implementation(libs.androidx.core)
    implementation(libs.splashscreen)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit.ext)
}