package com.ikxguru.view.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.ikxguru.data.Post
import com.ikxguru.ext.doOn
import com.ikxguru.repo.Repo
import com.ikxguru.view.posts.PostsViewModel.State
import com.ikxguru.view.posts.PostsViewModel.State.Failure
import com.ikxguru.view.posts.PostsViewModel.State.Success
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class PostsViewModel(
    private val repo: Repo
) : ViewModel() {

    sealed class State {
        data class Success(
            val loading: Boolean = false,
            val posts: List<Post> = emptyList()
        ) : State()

        data class Failure(val message: String) : State()

        companion object {
            val Loading = Success(loading = true)
        }
    }

    private val limit = 10
    private var start = 0
    private val _state = MutableLiveData<State>()
    private val state: LiveData<State>
        get() = _state
    val success
        get() = state.map { it.successOrNull() }
    val failure
        get() = state.map { it.failureOrNull() }
    val isLoading
        get() = state.map { it.successOrNull()?.loading }

    // view event
    private val _onClickPost = MutableLiveData<Post>()
    val onClickPost: LiveData<Post>
        get() = _onClickPost
    private val onClickPostChannel = ConflatedBroadcastChannel<Post>()

    init {
        viewModelScope.launch {
            onClickPostChannel
                .asFlow()
                .debounce(500L)
                .collect { _onClickPost.postValue(it) }
        }
    }

    fun loadInitialPosts() {
        fetchPosts()
    }

    private fun fetchPosts() {
        doOn(IO) {
            showLoading()

            repo.fetchPosts(start, limit)
                .fold({ success ->
                    val cachedPosts = state.successOrNull()?.posts ?: emptyList()
                    state.successOrNull()?.copy(
                        loading = false,
                        posts = cachedPosts + success.data
                    ) ?: Success(false, success.data)
                }, { failure ->
                    Failure(failure.error.message)
                })
                .let(_state::postValue)
        }
    }

    private fun showLoading() {
        val loading = state.successOrNull()?.copy(loading = true) ?: State.Loading
        _state.postValue(loading)
    }

    fun onClickPost(post: Post) {
        viewModelScope.launch {
            onClickPostChannel.send(post)
        }
    }

    fun loadMore() {
        if (isLoading()) return
        start += limit
        fetchPosts()
    }

    private fun isLoading(): Boolean = state.successOrNull()?.loading ?: false
}

internal fun State.successOrNull() = this as? Success

internal fun State.failureOrNull() = this as? Failure

internal fun LiveData<State>.successOrNull() = value?.successOrNull()