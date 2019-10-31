package com.ikxguru.ext

import com.ikxguru.base.ErrorResponse
import com.ikxguru.base.Result
import com.ikxguru.util.fromJson
import com.ikxguru.util.moshi
import retrofit2.Response

fun <T> Response<T>.toResult(): Result<T> {
    val code = code()
    return when {
        isSuccessful -> when (val body = body()) {
            null -> Result.Failure(code, ErrorResponse.NO_BODY)
            else -> Result.Success(code, body)
        }
        else -> Result.Failure(code, toErrorResponse())
    }
}

fun <T> Response<T>.toErrorResponse(): ErrorResponse {
    return errorBody()?.use { responseBody ->
        moshi.fromJson(ErrorResponse::class.java, responseBody.string())
    } ?: ErrorResponse.NO_BODY
}