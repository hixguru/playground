package com.ikxguru.view.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.ikxguru.base.Result
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

fun <T> LiveData<T>.getOrAwaitValues(
    latchCount: Int = 2
): List<T> {
    val data = arrayListOf<Any?>()
    val latch = CountDownLatch(latchCount)
    val observer = object : Observer<T> {
        override fun onChanged(o: T?) {
            data.add(o)
            if (data.size == latchCount) {
                removeObserver(this)
            }
        }
    }
    observeForever(observer)
    latch.await(2, TimeUnit.SECONDS)

    @Suppress("UNCHECKED_CAST")
    return data as List<T>
}

fun <T> T.toSuccessResponse() = Result.Success(200, this)