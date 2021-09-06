package com.osmanacikgoz.newsapp.view.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.osmanacikgoz.newsapp.R
import com.osmanacikgoz.newsapp.databinding.ActivityNewsListBinding
import com.osmanacikgoz.newsapp.view.ui.favorite.FavoriteFragment
import com.osmanacikgoz.newsapp.view.ui.news.NewsFragment
import com.osmanacikgoz.newsapp.view.ui.news.NewsViewModel
import kotlinx.coroutines.flow.collect
import org.koin.android.viewmodel.ext.android.viewModel

class NewsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsListBinding

    private val viewModel:NewsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_list)

        val newsFragment = NewsFragment()
        val favoriteFragment = FavoriteFragment()
        setCurrentFragment(newsFragment)
        val navbar = findViewById<BottomNavigationView>(R.id.bottomNavBar)
       /* viewModel.newsLiveData.observe(this){

        }

        */
        navbar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(newsFragment)
                R.id.favorite -> setCurrentFragment(favoriteFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            commit()
        }
    }
}