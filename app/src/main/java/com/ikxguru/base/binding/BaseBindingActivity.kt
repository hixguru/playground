package com.ikxguru.base.binding

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.ikxguru.ext.bind

abstract class BaseBindingActivity<B : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        binding = (bind(getLayoutId()) as B).apply {
            lifecycleOwner = this@BaseBindingActivity
        }
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun inject()
}