package com.ikxguru.remote

import com.ikxguru.data.Comment
import com.ikxguru.data.Post
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Remote {

    @GET("/posts")
    suspend fun fetchPosts(
        @Query("_start") start: Int,
        @Query("_limit") limit: Int
    ): Response<List<Post>>

    @GET("/posts/{postId}/comments")
    fun fetchComments(
        @Path("postId") postId: Int
    ): Single<Response<List<Comment>>>
}