package com.ikxguru.repo

import com.ikxguru.base.Response
import com.ikxguru.data.Post

interface Repo {

    suspend fun fetchPosts(): Response<List<Post>>
}