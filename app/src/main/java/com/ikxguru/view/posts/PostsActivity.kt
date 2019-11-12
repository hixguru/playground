package com.ikxguru.view.posts

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.ikxguru.R
import com.ikxguru.base.BaseBindingActivity
import com.ikxguru.constant.KEY_POST
import com.ikxguru.data.Post
import com.ikxguru.databinding.ActivityPostsBinding
import com.ikxguru.ext.observe
import com.ikxguru.ext.reachLastItem
import com.ikxguru.ext.start
import com.ikxguru.ext.toast
import com.ikxguru.view.detail.DetailActivity
import com.ikxguru.view.posts.PostsViewModel.ViewCommand.ShowPostDetail
import org.koin.android.viewmodel.ext.android.viewModel

class PostsActivity : BaseBindingActivity<ActivityPostsBinding>(), OnClickPostListener {

    private val vm: PostsViewModel by viewModel()
    private val adapter by lazy { PostsAdapter(this, lifecycle) }

    override fun getLayoutId(): Int = R.layout.activity_posts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

        loadInitialData()
        observe(vm.isLoading, adapter::setLoading)
        observeViewEvents()
        observeError()
    }

    private fun loadInitialData() {
        lifecycleScope.launchWhenCreated { vm.loadInitialPosts() }
    }

    private fun observeViewEvents() {
        observe(vm.viewCommand) { command ->
            when (command) {
                is ShowPostDetail -> showPostDetail(command)
                else -> Unit
            }
        }
    }

    private fun showPostDetail(command: ShowPostDetail) {
        start(DetailActivity::class, bundleOf(KEY_POST to command.post))
    }

    private fun initView() {
        binding.apply {
            vm = this@PostsActivity.vm
            rvPosts.adapter = this@PostsActivity.adapter
            // TODO It will be replaced with Paging Library
            rvPosts.addOnScrollListener(object : OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy <= 0) return
                    val shouldLoadMore = recyclerView.reachLastItem()
                    if (shouldLoadMore) this@PostsActivity.vm.loadMore()
                }
            })
        }
    }

    private fun observeError() {
        observe(vm.failure) { error ->
            error?.message?.let { toast(it) }
        }
    }

    override fun onClickPost(post: Post) = vm.onClickPost(post)
}
