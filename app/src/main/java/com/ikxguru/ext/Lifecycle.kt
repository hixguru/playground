package com.ikxguru.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, func: (T) -> Unit) {
    liveData.observe(this, Observer(func))
}