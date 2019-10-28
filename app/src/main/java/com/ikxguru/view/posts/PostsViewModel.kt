package com.ikxguru.view.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikxguru.data.Post
import com.ikxguru.repo.Repo
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostsViewModel(
    private val repo: Repo
) : ViewModel() {

    data class State(val posts: List<Post>)

    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    fun fetchData() {
        viewModelScope.launch(IO) {
            val posts = repo.fetchPosts()
            withContext(Main) {
                _state.value = State(posts = posts)
            }
        }
    }
}