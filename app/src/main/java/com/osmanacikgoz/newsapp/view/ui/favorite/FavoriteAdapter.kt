package com.osmanacikgoz.newsapp.view.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.osmanacikgoz.newsapp.databinding.RowNewsBinding
import com.osmanacikgoz.newsapp.model.entity.Favorites

class FavoriteAdapter(private val setOnClickListener: (favorite: Favorites?, position: Int) -> Unit) :
    RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private var favorites: List<Favorites>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding: RowNewsBinding =
            RowNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favorite = favorites?.get(position)
        holder.binding.run {
            favorite?.let { mFavotite ->
                newsTitle.text = mFavotite.title
                newsDescription.text = mFavotite.description ?: ""

                tvpublished.text = mFavotite.publishedAt

                Glide.with(holder.itemView)
                    .load(mFavotite.urlToImage)
                    .into(newsPoster)

                root.setOnClickListener {
                    setOnClickListener.invoke(mFavotite, position)
                }
            }
        }
    }

    override fun getItemCount(): Int = favorites?.size ?: 0

    fun setData(data: List<Favorites>?) {
        data?.let {
            favorites = it
            notifyDataSetChanged()
        }
    }

    class FavoriteViewHolder(val binding: RowNewsBinding) : RecyclerView.ViewHolder(binding.root)

}