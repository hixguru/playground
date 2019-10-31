package com.ikxguru.view.posts

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ikxguru.data.Post

@BindingAdapter("items", "loading", requireAll = true)
fun RecyclerView.submitList(items: List<Post>?, loading: Boolean?) {
    if (items == null || loading == true) return
    val adapter = adapter as? PostsAdapter ?: return
    adapter.submitList(items)
}