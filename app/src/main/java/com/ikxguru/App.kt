package com.ikxguru

import android.app.Application
import com.ikxguru.di.component.AppComponent
import com.ikxguru.di.component.DaggerAppComponent
import com.ikxguru.di.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(this@App)

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}