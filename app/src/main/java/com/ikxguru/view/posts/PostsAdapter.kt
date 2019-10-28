package com.ikxguru.view.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ikxguru.R
import com.ikxguru.base.BaseViewHolder
import com.ikxguru.data.Post
import com.ikxguru.databinding.LayoutPostItemBinding
import com.ikxguru.util.bind
import com.ikxguru.view.posts.PostsAdapter.PostViewHolder

class PostsAdapter(
    private val onClickPostListener: OnClickPostListener
) : ListAdapter<Post, PostViewHolder>(DiffCallback) {

    private lateinit var binding: LayoutPostItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = bind(inflater, R.layout.layout_post_item, parent, false)
        return PostViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class PostViewHolder(
        override val containerView: View
    ) : BaseViewHolder<Post>(containerView) {

        override fun onBind(item: Post) {
            binding.apply {
                post = item
                onClickPostListener = this@PostsAdapter.onClickPostListener
                executePendingBindings()
            }
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }
}