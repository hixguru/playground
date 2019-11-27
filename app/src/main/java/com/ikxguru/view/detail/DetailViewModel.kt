package com.ikxguru.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.ikxguru.base.DisposableViewModel
import com.ikxguru.data.Post
import com.ikxguru.ext.disposedBy
import com.ikxguru.ext.foldMap
import com.ikxguru.ext.observeOnMain
import com.ikxguru.repo.Repo
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class DetailViewModel @AssistedInject constructor(
    private val repo: Repo,
    @Assisted private val post: Post
) : DisposableViewModel() {

    sealed class State {
        data class Rendered(
            val post: Post,
            val comments: String
        ) : State()

        data class Error(val message: String) : State()
    }

    private val _state = MutableLiveData<State>()
    private val state: LiveData<State>
        get() = _state
    val rendered
        get() = state.map { state -> state as? State.Rendered }
    val error
        get() = state.map { state -> state as? State.Error }

    fun fetchComments() {
        repo.getComments(post.id)
            .foldMap({ success ->
                State.Rendered(
                    post = post,
                    comments = success.data.joinToString("\n") { it.body }
                )
            }, {
                State.Error(it.error.message)
            })
            .observeOnMain()
            .subscribe(_state::setValue)
            .disposedBy(disposables)
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(post: Post): DetailViewModel
    }
}