package com.ikxguru.view.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.ikxguru.base.Result
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.SECONDS

fun <T> LiveData<T>.getOrAwaitValues(
    expectedItemCount: Int,
    time: Long = 2,
    timeUnit: TimeUnit = SECONDS
): List<T> {
    val data = arrayListOf<Any?>()
    val latch = CountDownLatch(expectedItemCount)
    val observer = object : Observer<T> {
        override fun onChanged(o: T?) {
            data.add(o)
            if (data.size == expectedItemCount) {
                removeObserver(this)
            }
        }
    }
    observeForever(observer)
    latch.await(time, timeUnit)

    @Suppress("UNCHECKED_CAST")
    return data as List<T>
}

fun <T> T.toSuccessResponse() = Result.Success(200, this)