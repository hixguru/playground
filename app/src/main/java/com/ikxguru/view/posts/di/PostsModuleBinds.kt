package com.ikxguru.view.posts.di

import androidx.lifecycle.ViewModel
import com.ikxguru.di.annotations.ViewModelKey
import com.ikxguru.view.posts.PostsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PostsModuleBinds {

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(vm: PostsViewModel): ViewModel
}