package com.ikxguru.ext

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> AppCompatActivity.bind(@LayoutRes layoutId: Int): T {
    return DataBindingUtil.setContentView(this, layoutId)
}