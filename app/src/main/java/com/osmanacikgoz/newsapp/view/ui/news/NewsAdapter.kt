package com.osmanacikgoz.newsapp.view.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.osmanacikgoz.newsapp.databinding.RowNewsBinding
import com.osmanacikgoz.newsapp.model.entity.Article

class NewsAdapter(
    private val setOnClickListener: (article: Article, position: Int) -> Unit
) :
    PagingDataAdapter<Article, NewsAdapter.NewsHolder>(NewsDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val binding: RowNewsBinding =
            RowNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val news = getItem(position)

        holder.binding.run {
            news?.let { mNews ->
                newsTitle.text = mNews.title ?: ""
                newsDescription.text = mNews.author ?: ""

                Glide.with(holder.itemView)
                    .load(mNews.urlToImage)
                    .into(newsPoster)

                root.setOnClickListener {
                    setOnClickListener.invoke(mNews, position)
                }

            }
        }
    }

    class NewsHolder(val binding: RowNewsBinding) : RecyclerView.ViewHolder(binding.root)


    object NewsDiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }
}