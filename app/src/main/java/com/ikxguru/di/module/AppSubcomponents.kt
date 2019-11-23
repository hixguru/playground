package com.ikxguru.di.module

import com.ikxguru.view.detail.di.DetailComponent
import com.ikxguru.view.posts.di.PostsComponent
import dagger.Module

@Module(
    subcomponents = [
        PostsComponent::class,
        DetailComponent::class
    ]
)
class AppSubcomponents