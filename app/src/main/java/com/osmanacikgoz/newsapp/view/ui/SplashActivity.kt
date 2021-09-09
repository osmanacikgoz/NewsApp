package com.osmanacikgoz.newsapp.view.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.osmanacikgoz.newsapp.R
import com.osmanacikgoz.newsapp.databinding.ActivitySplashBinding
import kotlinx.coroutines.delay

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        lifecycleScope.launchWhenCreated {
            delay(2_000)
            val intent = Intent(this@SplashActivity, NewsListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}