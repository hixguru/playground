object Dependencies {
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"

    const val material = "com.google.android.material:material:${Version.material}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Version.recyclerview}"

    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val koin = "org.koin:koin-android:${Version.koin}"
    const val koinScope = "org.koin:koin-android-scope:${Version.koin}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Version.koin}"
    const val koinExt = "org.koin:koin-android-ext:${Version.koin}"

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel:${Version.lifecycle}"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
        const val extensions = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle}"
        const val liveDataCore = "androidx.lifecycle:lifecycle-livedata-core:${Version.lifecycle}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata:${Version.lifecycle}"
        const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime:${Version.lifecycle}"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    }

    const val rxJava = "io.reactivex.rxjava2:rxjava:${Version.rxJava}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Version.rxAndroid}"
    const val rxBinding = "com.jakewharton.rxbinding3:rxbinding:${Version.rxBinding}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${Version.okhttp}"
    const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"

    object Retrofit {
        const val retrofit2 = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val converterMoshi =
            "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
        const val adapterRxJava = "com.squareup.retrofit2:adapter-rxjava:${Version.retrofit}"
    }

    object Test {
        const val archTesting = "androidx.arch.core:core-testing:2.1.0"
        const val junit = "junit:junit:${Version.junit}"
        const val mockito = "org.mockito:mockito-core:${Version.mockito}"
        const val kluent = "org.amshove.kluent:kluent:${Version.kluent}"
        const val kluentAndroid = "org.amshove.kluent:kluent-android:${Version.kluent}"
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutine}"
    }
}