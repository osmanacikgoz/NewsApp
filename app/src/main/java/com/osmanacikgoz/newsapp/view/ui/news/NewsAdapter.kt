package com.osmanacikgoz.newsapp.view.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osmanacikgoz.newsapp.databinding.NewsItemBinding
import com.osmanacikgoz.newsapp.model.entity.Article

class NewsAdapter(var newsList: List<Article>, private val onItemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    private val items: MutableList<Article> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsHolder {
        val binding: NewsItemBinding =
            NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        with(holder.binding) {
            //newsList = items[position]

        }
    }

    override fun getItemCount(): Int = items.size

    class NewsHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root)
}