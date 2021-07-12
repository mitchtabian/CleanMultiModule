plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.codingwithmitch.cleanmultimodule"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    composeOptions {
        val compose = "1.0.0-rc01"
        kotlinCompilerExtensionVersion = compose
    }
}

dependencies{
    implementation(project(":home"))
    implementation(project(":account"))

    val coreKtx = "1.6.0"
    implementation("androidx.core:core-ktx:$coreKtx")

    val appCompat = "1.3.0"
    implementation("androidx.appcompat:appcompat:$appCompat")

    val material = "1.4.0"
    implementation("com.google.android.material:material:$material")

    val lifecycleRuntime = "2.3.1"
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntime")

    val lifecycleVmKtx = "2.4.0-alpha02"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVmKtx")

    val activityCompose = "1.3.0-rc01"
    implementation("androidx.activity:activity-compose:$activityCompose")

    val compose = "1.0.0-rc01"
    implementation("androidx.compose.ui:ui:$compose")
    implementation("androidx.compose.material:material:$compose")
    implementation("androidx.compose.ui:ui-tooling:$compose")

    val composeNavigation = "2.4.0-alpha04"
    implementation("androidx.navigation:navigation-compose:$composeNavigation")

    val hilt = "2.37"
    implementation("com.google.dagger:hilt-android:$hilt")
    kapt("com.google.dagger:hilt-compiler:$hilt")

    val hiltNavigationCompose = "1.0.0-alpha03"
    implementation("androidx.hilt:hilt-navigation-compose:$hiltNavigationCompose")
}










