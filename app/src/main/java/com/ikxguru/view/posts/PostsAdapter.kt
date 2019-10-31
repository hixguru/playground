package com.ikxguru.view.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ikxguru.R
import com.ikxguru.data.Post
import com.ikxguru.databinding.LayoutLoadingItemBinding
import com.ikxguru.databinding.LayoutPostItemBinding
import com.ikxguru.util.bind

enum class ViewType(resId: Int) {
    ITEM(R.layout.layout_post_item),
    LOADING(R.layout.layout_loading_item)
}

class PostsAdapter(
    private val postListener: OnClickPostListener
) : ListAdapter<Post, ViewHolder>(diffCallback) {

    private var isLoading: Boolean? = null

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            ViewType.LOADING.ordinal
        } else {
            ViewType.ITEM.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ViewType.ITEM.ordinal -> {
                val binding =
                    bind(inflater, R.layout.layout_post_item, parent) as LayoutPostItemBinding
                PostViewHolder(binding, postListener)
            }
            ViewType.LOADING.ordinal -> {
                val binding =
                    bind(inflater, R.layout.layout_loading_item, parent) as LayoutLoadingItemBinding
                LoadingViewHolder(binding)
            }
            else -> throw IllegalStateException()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is PostViewHolder -> holder.bind(getItem(position))
            is LoadingViewHolder -> Unit
            else -> throw IllegalStateException()
        }
    }

    private fun hasExtraRow(): Boolean {
        return isLoading != null && isLoading!!.not()
    }

    override fun getItemCount(): Int = super.getItemCount() + if (hasExtraRow()) 1 else 0

    fun setLoading(isLoading: Boolean?) {
        val previousLoading = this.isLoading
        val hadExtraRow = hasExtraRow()
        this.isLoading = isLoading
        val hasExtraRow = hasExtraRow()
        when {
            hadExtraRow != hasExtraRow -> {
                if (hadExtraRow) {
                    notifyItemRemoved(super.getItemCount())
                } else {
                    // do nothing
                }
            }
            hasExtraRow && previousLoading != isLoading -> {
                notifyItemChanged(itemCount - 1)
            }
            else -> Unit
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean =
                oldItem == newItem
        }
    }
}