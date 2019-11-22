package com.ikxguru.repo

import com.ikxguru.base.Result
import com.ikxguru.data.Post
import com.ikxguru.ext.toResult
import com.ikxguru.remote.Remote
import javax.inject.Inject

class RepoImpl @Inject constructor(
    private val remote: Remote
) : Repo {

    override suspend fun fetchPosts(
        start: Int,
        limit: Int
    ): Result<List<Post>> {
        return remote.fetchPosts(start, limit).toResult()
    }
}