package com.ikxguru.remote

import com.ikxguru.data.Post
import retrofit2.Response
import retrofit2.http.GET

interface Remote {

    @GET("/posts")
    suspend fun fetchPosts(): Response<List<Post>>
}