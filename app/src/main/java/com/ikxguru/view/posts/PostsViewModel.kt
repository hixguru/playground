package com.ikxguru.view.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.ikxguru.data.Post
import com.ikxguru.ext.doOn
import com.ikxguru.repo.Repo
import com.ikxguru.view.posts.PostsViewModel.State
import com.ikxguru.view.posts.PostsViewModel.State.Failure
import com.ikxguru.view.posts.PostsViewModel.State.Success
import kotlinx.coroutines.Dispatchers.IO

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

    private val _state = MutableLiveData<State>().apply { value = State.Loading }
    private val state: LiveData<State>
        get() = _state
    val success
        get() = state.map { it.successOrNull() }
    val failure
        get() = state.map { it.failureOrNull() }

    fun fetchData() {
        doOn(IO) {
            val posts = repo.fetchPosts()

            posts.fold({ success ->
                _state.postValue(Success(posts = success.data))
            }, { failure ->
                _state.postValue(Failure(failure.error.message))
            })
        }
    }
}

internal fun State.successOrNull() = this as? Success

internal fun State.failureOrNull() = this as? Failure