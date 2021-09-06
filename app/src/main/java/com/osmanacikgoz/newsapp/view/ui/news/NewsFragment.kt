package com.osmanacikgoz.newsapp.view.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.osmanacikgoz.newsapp.R
import com.osmanacikgoz.newsapp.databinding.FragementNewsBinding

class NewsFragment : Fragment() {

    private lateinit var binding: FragementNewsBinding
    val adapter : NewsAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.activity_news_list,
            container,
            false)
        return binding.root

    }



}