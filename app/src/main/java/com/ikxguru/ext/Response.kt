package com.ikxguru.ext

import com.ikxguru.base.ErrorResponse
import com.ikxguru.util.fromJson
import com.ikxguru.util.moshi
import retrofit2.Response

fun <T> Response<T>.toResult(): com.ikxguru.base.Response<T> {
    val code = code()
    return when {
        isSuccessful -> when (val body = body()) {
            null -> com.ikxguru.base.Response.Failure(code, ErrorResponse.NO_BODY)
            else -> com.ikxguru.base.Response.Success(code, body)
        }
        else -> com.ikxguru.base.Response.Failure(code, toErrorResponse())
    }
}

fun <T> Response<T>.toErrorResponse(): ErrorResponse {
    return errorBody()?.use { responseBody ->
        moshi.fromJson(ErrorResponse::class.java, responseBody.string())
    } ?: ErrorResponse.NO_BODY
}