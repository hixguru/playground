object Dependencies {
    const val kotlinStdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val koin = "org.koin:koin-android:${Version.koin}"
    const val koinScope = "org.koin:koin-android-scope:${Version.koin}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Version.koin}"
    const val koinExt = "org.koin:koin-android-ext:${Version.koin}"

    const val rxJava = "io.reactivex.rxjava2:rxjava:${Version.rxJava}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Version.rxAndroid}"

    object Retrofit {
        const val retrofit2 = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val converterMoshi =
            "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
        const val adapterRxJava = "com.squareup.retrofit2:adapter-rxjava:${Version.retrofit}"
    }

    object Test {
        const val junit = "junit:junit:${Version.junit}"
    }
}