package com.ikxguru.remote

import com.ikxguru.data.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Remote {

    @GET("/posts")
    suspend fun fetchPosts(
        @Query("_start") start: Int,
        @Query("_limit") limit: Int
    ): Response<List<Post>>
}