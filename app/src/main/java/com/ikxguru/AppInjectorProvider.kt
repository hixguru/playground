package com.ikxguru

import android.app.Activity
import com.ikxguru.di.component.AppComponent

interface AppInjectorProvider {
    val appComponent: AppComponent
}

internal val Activity.injector: AppComponent
    get() = (application as AppInjectorProvider).appComponent