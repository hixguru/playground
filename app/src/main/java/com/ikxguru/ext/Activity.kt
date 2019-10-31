package com.ikxguru.ext

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlin.reflect.KClass

fun <T : ViewDataBinding> AppCompatActivity.bind(@LayoutRes layoutId: Int): T {
    return DataBindingUtil.setContentView(this, layoutId)
}

fun AppCompatActivity.start(
    kClass: KClass<out Activity>,
    bundle: Bundle? = null
) {
    val intent = Intent(this, kClass.java).apply {
        bundle?.let(this::putExtras)
    }
    startActivity(intent)
}