package com.osmanacikgoz.newsapp.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.osmanacikgoz.newsapp.R
import com.osmanacikgoz.newsapp.databinding.ActivityNewsListBinding
import com.osmanacikgoz.newsapp.enums.HomePageType
import com.osmanacikgoz.newsapp.extension.showFragment
import com.osmanacikgoz.newsapp.view.ui.favorite.FavoriteFragment
import com.osmanacikgoz.newsapp.view.ui.news.NewsFragment

class NewsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsListBinding

    // Fragments
    private var newsFragment: Fragment? = null
    private var favoriteNewsFragment: Fragment? = null

    private val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_list)

        initializedUI()
        setNavBarItemSelectedListener()
    }

    private fun setNavBarItemSelectedListener() {
        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.news -> {
                    setCurrentFragment(HomePageType.NEWS_PAGE)
                }
                R.id.favorite -> {
                    setCurrentFragment(HomePageType.FAVORITE_NEWS_PAGE)
                }
            }
            true
        }
    }

    private fun initializedUI() {
        setCurrentFragment(HomePageType.NEWS_PAGE)
    }

    private fun setCurrentFragment(homePageType: HomePageType) {
        val selectedFragment = when (homePageType) {
            HomePageType.NEWS_PAGE -> {
                newsFragment ?: NewsFragment()
            }
            HomePageType.FAVORITE_NEWS_PAGE -> {
                favoriteNewsFragment ?: FavoriteFragment()
            }
        }
       showFragment(R.id.fragmentContainer, selectedFragment)

    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}