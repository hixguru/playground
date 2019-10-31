package com.ikxguru.view.posts

import com.ikxguru.base.BaseBindingViewHolder
import com.ikxguru.data.Post
import com.ikxguru.databinding.LayoutPostItemBinding

class PostViewHolder(
    binding: LayoutPostItemBinding,
    private val listener: OnClickPostListener
) : BaseBindingViewHolder<LayoutPostItemBinding>(binding) {
    fun bind(item: Post) {
        binding.apply {
            post = item
            listener = this@PostViewHolder.listener
            executePendingBindings()
        }
    }
}