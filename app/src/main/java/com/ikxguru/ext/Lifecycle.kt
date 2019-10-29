package com.ikxguru.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

fun <T : Any?, L : LiveData<T>> LifecycleOwner.observe(liveData: L, func: (T) -> Unit) {
    liveData.observe(this, Observer(func))
}

fun ViewModel.doOn(
    context: CoroutineContext,
    action: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.launch(context = context, block = action)
}