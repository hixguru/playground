package com.ikxguru.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> bind(
    inflater: LayoutInflater,
    @LayoutRes layoutId: Int,
    parent: ViewGroup? = null,
    attachToRoot: Boolean = false
): T {
    return DataBindingUtil.inflate(inflater, layoutId, parent, attachToRoot)
}