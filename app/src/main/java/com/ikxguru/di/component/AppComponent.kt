package com.ikxguru.di.component

import android.content.Context
import com.ikxguru.di.module.ApiModule
import com.ikxguru.di.module.AppModuleBinds
import com.ikxguru.di.module.AppSubcomponents
import com.ikxguru.di.module.ViewModelModule
import com.ikxguru.view.posts.di.PostsComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModuleBinds::class,
        AppSubcomponents::class,
        ViewModelModule::class
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
}