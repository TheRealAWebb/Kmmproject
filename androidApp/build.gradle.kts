plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    namespace = "com.awebber.kmmproject.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.awebber.kmmproject.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}

dependencies {
    implementation(project(":shared"))
    implementation(compose.ui)
    implementation(compose.uiTooling)
    implementation(compose.preview)
    implementation(compose.foundation)
    implementation(compose.material)
    @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
    implementation("androidx.activity:activity-compose:1.7.1")
    implementation(compose.material3)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
}