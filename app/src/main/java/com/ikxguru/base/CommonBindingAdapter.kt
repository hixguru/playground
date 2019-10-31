package com.ikxguru.base

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("goneUnless")
fun View.goneUnless(visible: Boolean) {
    visibility = when (visible) {
        true -> View.VISIBLE
        else -> View.GONE
    }
}