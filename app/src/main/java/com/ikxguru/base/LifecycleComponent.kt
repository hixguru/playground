package com.ikxguru.base

import android.view.View
import android.view.View.OnClickListener
import androidx.databinding.DataBindingComponent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.ikxguru.ext.disposedBy
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class LifecycleComponent(
    private val lifecycle: Lifecycle
) : DataBindingComponent, LifecycleObserver {

    private val disposables = CompositeDisposable()

    init {
        lifecycle.addObserver(this)
    }

    override fun getClickBinding(): ClickBinding {
        return object : ClickBinding {
            override fun View.bindClick(listener: OnClickListener) {
                clicks()
                    .throttleFirst(300, TimeUnit.MILLISECONDS)
                    .subscribe({
                        listener.onClick(this)
                    }, Throwable::printStackTrace)
                    .disposedBy(disposables)
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun dispose() {
        disposables.clear()
        lifecycle.removeObserver(this)
    }
}