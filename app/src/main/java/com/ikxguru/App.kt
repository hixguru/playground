package com.ikxguru

import android.app.Application
import com.ikxguru.di.component.AppComponent
import com.ikxguru.di.component.DaggerAppComponent

class App : Application(), AppInjectorProvider {

    override val appComponent: AppComponent
        get() = DaggerAppComponent.factory().create(this)
}