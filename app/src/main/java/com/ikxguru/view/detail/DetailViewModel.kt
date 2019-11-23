package com.ikxguru.view.detail

import androidx.lifecycle.ViewModel
import com.ikxguru.data.Post
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class DetailViewModel @AssistedInject constructor(
    @Assisted private val post: Post
) : ViewModel() {

    fun getPost() = post

    @AssistedInject.Factory
    interface Factory {
        fun create(post: Post): DetailViewModel
    }
}