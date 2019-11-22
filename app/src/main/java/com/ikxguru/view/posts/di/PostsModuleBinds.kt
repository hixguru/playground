package com.ikxguru.view.posts.di

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.ikxguru.di.annotations.ViewModelKey
import com.ikxguru.view.posts.PostsActivity
import com.ikxguru.view.posts.PostsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PostsModuleBinds {

    @Binds
    abstract fun provideActivity(postsActivity: PostsActivity): Activity

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(vm: PostsViewModel): ViewModel
}