package com.osmanacikgoz.newsapp.extension

import android.content.Intent
import androidx.fragment.app.Fragment
import com.osmanacikgoz.newsapp.api.Api
import com.osmanacikgoz.newsapp.model.entity.Article
import com.osmanacikgoz.newsapp.view.ui.news.detail.NewsDetailActivity

fun Fragment.showFragment(resContainerId: Int, fragment: Fragment) {
    parentFragmentManager.beginTransaction().apply {
        replace(resContainerId, fragment)
        commit()
    }
}

fun Fragment.navigateToDetailActivity(article: Article) {
    val intent = Intent(requireContext(), NewsDetailActivity::class.java)
    intent.putExtra(Api.DETAIL_ARTICLE, article)
    startActivity(intent)
}