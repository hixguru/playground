package com.ikxguru.base

import android.view.View
import androidx.databinding.BindingAdapter

interface ClickBinding {

    @BindingAdapter("android:onClick")
    fun View.bindClick(listener: View.OnClickListener)
}