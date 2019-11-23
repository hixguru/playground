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

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        kotlinOptions {
            jvmTarget = "1.8"
        }

        dataBinding {
            isEnabled = true
        }

        buildConfigField("String", "END_POINT", "\"https://jsonplaceholder.typicode.com/\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

androidExtensions {
    isExperimental = true
}

dependencies {
    implementation(kotlin("stdlib-jdk8", Version.kotlin))
    implementation(Dependencies.coroutine)

    implementation(Dependencies.material)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.recyclerview)

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.constraintlayout)

    implementation(Dependencies.Lifecycle.viewModel)
    implementation(Dependencies.Lifecycle.viewModelKtx)
    implementation(Dependencies.Lifecycle.extensions)
    implementation(Dependencies.Lifecycle.liveDataCore)
    implementation(Dependencies.Lifecycle.liveData)
    implementation(Dependencies.Lifecycle.liveDataKtx)
    implementation(Dependencies.Lifecycle.runtime)
    implementation(Dependencies.Lifecycle.runtimeKtx)
    implementation(Dependencies.Lifecycle.activityKtx)
    implementation(Dependencies.Lifecycle.fragmentKtx)

    implementation(Dependencies.rxJava)
    implementation(Dependencies.rxAndroid)
    implementation(Dependencies.rxBinding)

    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttpInterceptor)
    implementation(Dependencies.Retrofit.retrofit2)
    implementation(Dependencies.Retrofit.converterMoshi)
    implementation(Dependencies.Retrofit.adapterRxJava)

    implementation(Dependencies.koin)
    implementation(Dependencies.koinExt)
    implementation(Dependencies.koinScope)
    implementation(Dependencies.koinViewModel)
    implementation(Dependencies.dagger)
    kapt(Dependencies.daggerCompiler)

    compileOnly(Dependencies.AssistedInject.annotations)
    kapt(Dependencies.AssistedInject.processor)

    testImplementation(Dependencies.Test.archTesting)
    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.mockito)
    testImplementation(Dependencies.Test.kluent)
    testImplementation(Dependencies.Test.coroutine)
}