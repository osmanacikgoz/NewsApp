package com.osmanacikgoz.newsapp.view.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.osmanacikgoz.newsapp.R
import com.osmanacikgoz.newsapp.databinding.FragementNewsBinding
import com.osmanacikgoz.newsapp.extension.navigateToDetailActivity
import com.osmanacikgoz.newsapp.model.entity.Article
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class NewsFragment : Fragment() {

    private lateinit var binding: FragementNewsBinding
    private val viewModel: NewsViewModel by viewModel()

    private var newsAdapter: NewsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragement_news,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()

        binding.edtNewsSearch.addTextChangedListener {
            it.toString().let { searchParam ->

            }
        }
    }

    private fun initializeUI() {
        setupList()
        setupView("bitcoin")
    }

    private fun setupList() {
        newsAdapter = NewsAdapter { article, _ ->
            navigateToDetail(article)
        }
        binding.rvNews.adapter = newsAdapter
    }

    private fun setupView(searchParam: String = "") {
        lifecycleScope.launch {
            viewModel.searchNews(searchParam).collect {
                newsAdapter?.submitData(it)
            }
        }
    }

    private fun navigateToDetail(article: Article?) {
        article?.let {
            navigateToDetailActivity(it)
        }
    }
}