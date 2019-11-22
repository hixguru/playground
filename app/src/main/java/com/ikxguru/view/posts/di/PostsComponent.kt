package com.ikxguru.view.posts.di

import com.ikxguru.di.annotations.ActivityScope
import com.ikxguru.view.posts.PostsActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface PostsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): PostsComponent
    }

    fun inject(activity: PostsActivity)
}