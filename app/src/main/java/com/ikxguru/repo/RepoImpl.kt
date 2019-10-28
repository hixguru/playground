package com.ikxguru.repo

import com.ikxguru.data.Post
import com.ikxguru.remote.Remote

class RepoImpl(
    private val remote: Remote
) : Repo {

    override suspend fun fetchPosts(): List<Post> {
        return remote.fetchPosts()
    }
}