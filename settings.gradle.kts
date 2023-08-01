pluginManagement {
    includeBuild("build-dependency")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
        maven(url = uri("https://oss.sonatype.org/content/repositories/snapshots/"))
    }
}

rootProject.name = "hearthstone"
include (":app")
include(":feature-home")
include(":core-networking")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
