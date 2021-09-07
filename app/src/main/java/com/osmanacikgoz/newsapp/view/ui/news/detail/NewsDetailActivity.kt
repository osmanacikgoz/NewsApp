package com.osmanacikgoz.newsapp.view.ui.news.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.osmanacikgoz.newsapp.R
import com.osmanacikgoz.newsapp.api.Api
import com.osmanacikgoz.newsapp.databinding.ActivityNewsDetailBinding
import com.osmanacikgoz.newsapp.model.entity.Article

class NewsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsDetailBinding

    private var article: Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_detail)
        getDataExtra()
        initializeUI()
    }

    private fun initializeUI() {
        with(binding) {
            article?.let {
                tvDescription.text = it.description

                Glide.with(this@NewsDetailActivity)
                    .load(it.urlToImage)
                    .into(ivDetailPoster)
            }
        }
    }

    private fun setClickListeners() {
        with(binding) {

        }
    }

    private fun getDataExtra() {
        article = intent.getParcelableExtra(Api.DETAIL_ARTICLE) as? Article
    }

}