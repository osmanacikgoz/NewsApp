package com.osmanacikgoz.newsapp.view.ui.news.detail

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.osmanacikgoz.newsapp.R
import com.osmanacikgoz.newsapp.api.Api
import com.osmanacikgoz.newsapp.databinding.ActivityNewsDetailBinding
import com.osmanacikgoz.newsapp.extension.sharePlainText
import com.osmanacikgoz.newsapp.model.entity.Article
import com.osmanacikgoz.newsapp.model.entity.Favorites
import com.osmanacikgoz.newsapp.room.FavoriteNewsDao
import com.osmanacikgoz.newsapp.view.ui.WebViewActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class NewsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsDetailBinding

    private val newsDao: FavoriteNewsDao by inject()

    private var article: Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_detail)
        getDataExtra()
        initializeUI()
        setClickListeners()
    }

    private fun initializeUI() {
        with(binding) {
            article?.let {
                tvDescription.text = it.description

                Glide.with(this@NewsDetailActivity)
                    .load(it.urlToImage)
                    .into(ivDetailPoster)

            }
            setFavoriteState()
        }
    }

    private fun setClickListeners() {
        with(binding) {

            ivBack.setOnClickListener {
                finish()
            }

            ivShare.setOnClickListener {
                sharePlainText(article?.url)
            }

            mbSource.setOnClickListener {
                val intent = Intent(applicationContext, WebViewActivity::class.java)
                intent.putExtra(Api.WEBVIEW_SOURCE_URL, article?.url)
                startActivity(intent)
            }

            ivFavorite.setOnClickListener {
                toggleFavorite()
            }
        }
    }

    private fun toggleFavorite() {
        lifecycleScope.launch(Dispatchers.Main) {
            if (newsDao.getId().contains(article?.title)) {
                val favorites = Favorites(
                    article?.source,
                    article?.author,
                    article?.title ?: "",
                    article?.description,
                    article?.url,
                    article?.urlToImage,
                    article?.publishedAt,
                    article?.content
                )
                newsDao.deleteArticle(favorites)
                Toast.makeText(
                    applicationContext,
                    "Favorilerden Çıkarıldı",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val favorites = Favorites(
                    article?.source,
                    article?.author,
                    article?.title ?: "",
                    article?.description,
                    article?.url,
                    article?.urlToImage,
                    article?.publishedAt,
                    article?.content
                )
                newsDao.insertArticle(favorites)

                Toast.makeText(applicationContext, "Favorilere Eklendi", Toast.LENGTH_LONG)
                    .show()

            }
            setFavoriteState()
        }
    }

    private fun setFavoriteState() {
        lifecycleScope.launch(Dispatchers.Main) {
            if (newsDao.getId().contains(article?.title)) {
                binding.ivFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
            } else {
                binding.ivFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
        }
    }

    private fun getDataExtra() {
        article = intent.getParcelableExtra(Api.DETAIL_ARTICLE)
    }

}