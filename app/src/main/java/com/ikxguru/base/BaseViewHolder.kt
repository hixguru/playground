package com.ikxguru.base

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<T>(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    protected val context: Context by lazy { itemView.context }

    abstract fun onBind(item: T)
}