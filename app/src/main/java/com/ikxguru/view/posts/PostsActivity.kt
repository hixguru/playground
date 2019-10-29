package com.ikxguru.view.posts

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.ikxguru.R
import com.ikxguru.base.BaseBindingActivity
import com.ikxguru.data.Post
import com.ikxguru.databinding.ActivityPostsBinding
import com.ikxguru.ext.observe
import com.ikxguru.ext.toast
import com.ikxguru.view.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class PostsActivity : BaseBindingActivity<ActivityPostsBinding>(), OnClickPostListener {

    private val vm: PostsViewModel by viewModel()
    private val adapter by lazy { PostsAdapter(this) }

    override fun getLayoutId(): Int = R.layout.activity_posts

    override fun loadInitialData() {
        lifecycleScope.launchWhenCreated { vm.fetchData() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        observeState()
    }

    private fun initView() {
        binding.apply {
            vm = this@PostsActivity.vm
            rvPosts.adapter = this@PostsActivity.adapter
        }
    }

    private fun observeState() {
        observe(vm.failure) { error ->
            error ?: return@observe
            toast(error.message)
        }
    }

    override fun onClickPostListener(post: Post) {
        startActivity(Intent(this, DetailActivity::class.java))
    }
}
