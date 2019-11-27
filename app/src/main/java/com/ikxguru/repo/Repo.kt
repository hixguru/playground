package com.ikxguru.repo

import com.ikxguru.base.Result
import com.ikxguru.data.Comment
import com.ikxguru.data.Post
import io.reactivex.Single

interface Repo {

    suspend fun fetchPosts(
        start: Int,
        limit: Int
    ): Result<List<Post>>

    fun getComments(postId: Int): Single<Result<List<Comment>>>
}