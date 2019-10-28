object Dependencies {
    const val kotlinStdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"

    object Test {
        const val junit = "junit:junit:${Version.junit}"
    }
}