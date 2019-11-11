package com.ikxguru.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import com.ikxguru.base.LifecycleComponent
import com.squareup.moshi.Moshi

val moshi = Moshi.Builder().build()

fun <T> Moshi.fromJson(cls: Class<T>, json: String): T? {
    return moshi.adapter<T>(cls::class.java).fromJson(json)
}

fun <T : ViewDataBinding> bind(
    inflater: LayoutInflater,
    @LayoutRes layoutId: Int,
    parent: ViewGroup? = null,
    attachToRoot: Boolean = false,
    lifecycle: Lifecycle? = null
): T {
    val bindingComponent: DataBindingComponent? = lifecycle?.run { LifecycleComponent(this) }
    return DataBindingUtil.inflate(inflater, layoutId, parent, attachToRoot, bindingComponent)
}