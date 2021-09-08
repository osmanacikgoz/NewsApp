package com.osmanacikgoz.newsapp.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.osmanacikgoz.newsapp.R
import com.osmanacikgoz.newsapp.api.Api
import com.osmanacikgoz.newsapp.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    private var sourceNewsUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web_view)
        getIntentData()
        initializeUI()
    }

    private fun initializeUI() {
        sourceNewsUrl?.let {
            binding.wvNewsSource.loadUrl(it)
        }
    }

    private fun getIntentData() {
        sourceNewsUrl = intent.getStringExtra(Api.WEBVIEW_SOURCE_URL) as? String
    }

}