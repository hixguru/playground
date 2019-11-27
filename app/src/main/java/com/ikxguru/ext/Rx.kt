package com.ikxguru.ext

import com.ikxguru.base.ErrorResponse
import com.ikxguru.base.Result
import com.ikxguru.base.Result.Failure
import com.ikxguru.base.Result.Success
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import retrofit2.Response

fun Disposable.disposedBy(disposables: CompositeDisposable) {
    disposables.add(this)
}

fun <T> Single<Response<T>>.mapResult(): Single<Result<T>> = map { response ->
    val code = response.code()
    if (response.isSuccessful) {
        when (val body = response.body()) {
            null -> Result.Failure<T>(code, ErrorResponse.NO_BODY)
            else -> Result.Success(code, body)
        }
    } else {
        Result.Failure(code, response.toErrorResponse())
    }
}

fun <T, R> Single<Result<T>>.foldMap(
    success: (Success<out T>) -> R,
    failure: (Failure<out T>) -> R
) = map { result ->
    result.fold(success, failure)
}

fun <T> Single<T>.observeOnMain() = observeOn(AndroidSchedulers.mainThread())