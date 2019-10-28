plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Android.compileSdkVersion)
    buildToolsVersion(Android.buildToolsVersion)

    defaultConfig {
        applicationId = "com.ikxguru"
        minSdkVersion(Android.minSdkVersion)
        targetSdkVersion(Android.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8", Version.kotlin))
    implementation(Dependencies.appCompat)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.constraintlayout)

    implementation(Dependencies.rxJava)
    implementation(Dependencies.rxAndroid)

    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttpInterceptor)
    implementation(Dependencies.Retrofit.retrofit2)
    implementation(Dependencies.Retrofit.converterMoshi)
    implementation(Dependencies.Retrofit.adapterRxJava)

    implementation(Dependencies.koin)
    implementation(Dependencies.koinExt)
    implementation(Dependencies.koinScope)
    implementation(Dependencies.koinViewModel)

    testImplementation(Dependencies.Test.junit)
}