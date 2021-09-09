package com.osmanacikgoz.newsapp.view.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.osmanacikgoz.newsapp.R
import com.osmanacikgoz.newsapp.databinding.FragmentFavoriteBinding
import com.osmanacikgoz.newsapp.extension.navigateToDetailActivity
import com.osmanacikgoz.newsapp.model.entity.Article
import org.koin.android.ext.android.inject

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding

    private val viewModel: FavoriteViewModel by inject()

    private var favoriteAdapter: FavoriteAdapter? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_favorite,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        observeFavoriteNews()
    }

    private fun initializeUI() {
        initFavoriteAdapter()
    }

    private fun initFavoriteAdapter() {
        favoriteAdapter = FavoriteAdapter { favorite, position ->
            favorite?.let {
                val article = Article(
                    it.source,
                    it.author,
                    it.title,
                    it.description,
                    it.url,
                    it.urlToImage,
                    it.publishedAt,
                    it.content,
                )
                navigateToDetail(article)
            }
        }
        binding.rvFavorites.adapter = favoriteAdapter
    }

    private fun observeFavoriteNews() {
        viewModel.favoriteNewsLiveData.observe(viewLifecycleOwner, { favoriteNewsList ->
            favoriteAdapter?.setData(favoriteNewsList.reversed())
        })
    }

    private fun navigateToDetail(article: Article?) {
        article?.let {
            navigateToDetailActivity(it)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchFavorites()
    }
}

