@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.hearthstone.application")
}

dependencies {
    implementation(project(":feature-home"))
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit.ext)
}