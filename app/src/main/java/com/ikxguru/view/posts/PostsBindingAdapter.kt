package com.ikxguru.view.posts

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ikxguru.data.Post

@BindingAdapter("items")
fun RecyclerView.submitList(items: List<Post>?) {
    items ?: return
    val adapter = adapter as? PostsAdapter ?: return
    adapter.submitList(items)
}