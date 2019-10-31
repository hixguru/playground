package com.ikxguru.base

sealed class Result<T>(@Transient open val code: Int) {

    data class Success<T>(
        override val code: Int,
        val data: T
    ) : Result<T>(code)

    data class Failure<T>(
        override val code: Int,
        val error: ErrorResponse
    ) : Result<T>(code)

    fun <R> fold(
        success: (Success<out T>) -> R,
        failure: (Failure<out T>) -> R
    ): R = when (this) {
        is Success -> success(this)
        is Failure -> failure(this)
    }
}