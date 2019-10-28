package com.ikxguru.repo

import com.ikxguru.data.Post

interface Repo {

    suspend fun fetchPosts(): List<Post>
}