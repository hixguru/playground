package com.ikxguru.repo

import com.ikxguru.data.Post
import com.ikxguru.ext.toResult
import com.ikxguru.remote.Remote
import com.ikxguru.base.Response as MappedResponse

class RepoImpl(
    private val remote: Remote
) : Repo {

    override suspend fun fetchPosts(): MappedResponse<List<Post>> {
        return remote.fetchPosts().toResult()
    }
}