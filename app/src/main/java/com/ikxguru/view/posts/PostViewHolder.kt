package com.ikxguru.view.posts

import com.ikxguru.base.binding.BaseBindingViewHolder
import com.ikxguru.data.Post
import com.ikxguru.databinding.LayoutPostItemBinding

class PostViewHolder(
    binding: LayoutPostItemBinding,
    private val listener: PostClickListener
) : BaseBindingViewHolder<LayoutPostItemBinding>(binding) {
    fun bind(item: Post) {
        binding.apply {
            post = item
            listener = this@PostViewHolder.listener
            executePendingBindings()
        }
    }
}