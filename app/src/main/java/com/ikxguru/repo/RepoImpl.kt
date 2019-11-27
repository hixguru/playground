package com.ikxguru.repo

import com.ikxguru.base.Result
import com.ikxguru.data.Comment
import com.ikxguru.data.Post
import com.ikxguru.ext.mapResult
import com.ikxguru.remote.Remote
import io.reactivex.Single
import javax.inject.Inject

class RepoImpl @Inject constructor(
    private val remote: Remote
) : Repo {

    override suspend fun fetchPosts(
        start: Int,
        limit: Int
    ): Result<List<Post>> {
        return remote.fetchPosts(start, limit).mapResult()
    }

    override fun getComments(postId: Int): Single<Result<List<Comment>>> {
        return remote.fetchComments(postId)
            .mapResult()
    }
}