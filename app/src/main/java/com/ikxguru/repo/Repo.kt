package com.ikxguru.repo

import com.ikxguru.base.Result
import com.ikxguru.data.Post

interface Repo {

    suspend fun fetchPosts(
        start: Int,
        limit: Int
    ): Result<List<Post>>
}