package com.ikxguru.ext

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.didReachLastItem(): Boolean {
    val lm = layoutManager as? LinearLayoutManager ?: return false
    val visibleItemCount = lm.childCount
    val totalItemCount = lm.itemCount
    val pastVisiblePosition = lm.findFirstVisibleItemPosition()

    return visibleItemCount + pastVisiblePosition >= totalItemCount
}