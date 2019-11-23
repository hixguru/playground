package com.ikxguru.di.component

import android.content.Context
import com.ikxguru.di.module.ApiModule
import com.ikxguru.di.module.AppModuleBinds
import com.ikxguru.di.module.AppSubcomponents
import com.ikxguru.view.detail.di.DetailComponent
import com.ikxguru.view.posts.di.PostsComponent
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModuleBinds::class,
        AppSubcomponents::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }

    fun postsComponent(): PostsComponent.Factory
    fun detailComponent(): DetailComponent.Factory
}

@AssistedModule
@Module(includes = [AssistedInject_AssistedInjectModule::class])
interface AssistedInjectModule