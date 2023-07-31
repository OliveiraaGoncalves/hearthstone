@file:Suppress("UnstableApiUsage")

import extensions.setupAndroidDefaultConfig
import extensions.setupCompileOptions
import extensions.setupPackingOptions
import gradle.kotlin.dsl.accessors._f5177550c20f82cf6909e67a1981b117.android

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = Config.applicationId

    setupCompileOptions()
    setupPackingOptions()
    setupAndroidDefaultConfig()

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName
        multiDexEnabled = true
    }
}