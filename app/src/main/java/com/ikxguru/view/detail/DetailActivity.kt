package com.ikxguru.view.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ikxguru.R
import com.ikxguru.constant.KEY_POST
import com.ikxguru.data.Post

class DetailActivity : AppCompatActivity() {

    private val post by lazy { intent?.getParcelableExtra(KEY_POST) ?: Post() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        Log.e("post", post.toString())
    }
}
