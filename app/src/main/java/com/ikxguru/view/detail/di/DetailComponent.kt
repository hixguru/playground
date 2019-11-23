package com.ikxguru.view.detail.di

import com.ikxguru.di.annotations.ActivityScope
import com.ikxguru.di.component.AssistedInjectModule
import com.ikxguru.di.module.ViewModelModule
import com.ikxguru.view.detail.DetailActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        ViewModelModule::class,
        DetailModule::class,
        AssistedInjectModule::class
    ]
)
interface DetailComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DetailComponent
    }

    fun inject(activity: DetailActivity)
}