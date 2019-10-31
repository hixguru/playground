package com.ikxguru.base

import android.content.Context
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class BaseBindingViewHolder<BINDING : ViewDataBinding>(
    protected val binding: BINDING
) : RecyclerView.ViewHolder(binding.root), LayoutContainer {

    override val containerView: View?
        get() = binding.root

    protected val context: Context by lazy { itemView.context }
}