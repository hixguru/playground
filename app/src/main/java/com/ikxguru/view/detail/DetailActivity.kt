package com.ikxguru.view.detail

import android.os.Bundle
import com.ikxguru.R
import com.ikxguru.base.BaseBindingActivity
import com.ikxguru.constant.KEY_POST
import com.ikxguru.data.Post
import com.ikxguru.databinding.ActivityDetailBinding

class DetailActivity : BaseBindingActivity<ActivityDetailBinding>() {

    private val post by lazy { intent?.getParcelableExtra(KEY_POST) ?: Post() }

    override fun getLayoutId(): Int = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.post = this@DetailActivity.post
    }
}
