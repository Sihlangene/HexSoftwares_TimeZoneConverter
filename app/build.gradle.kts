plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.timezoneconverter"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.timezoneconverter"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

        implementation("androidx.appcompat:appcompat:1.4.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.0")
        implementation("com.google.android.material:material:1.4.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
        implementation("com.jakewharton.timber:timber:4.7.1")
        implementation("com.jakewharton.threetenabp:threetenabp:1.3.1") // For working with date-time APIs


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}