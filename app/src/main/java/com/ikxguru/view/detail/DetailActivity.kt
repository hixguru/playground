package com.ikxguru.view.detail

import android.os.Bundle
import com.ikxguru.R
import com.ikxguru.base.BaseBindingActivity
import com.ikxguru.constant.KEY_POST
import com.ikxguru.data.Post
import com.ikxguru.databinding.ActivityDetailBinding
import com.ikxguru.ext.viewModel
import com.ikxguru.injector
import com.ikxguru.util.IntentDelegate
import javax.inject.Inject

class DetailActivity : BaseBindingActivity<ActivityDetailBinding>() {

    private val post by IntentDelegate<Post>(KEY_POST, Post())
    @Inject lateinit var vmf: DetailViewModel.Factory
    private val vm: DetailViewModel by viewModel { vmf.create(post) }

    override fun getLayoutId(): Int = R.layout.activity_detail

    override fun inject() = injector.detailComponent().create().inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.post = vm.getPost()
    }
}
