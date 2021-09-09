package com.osmanacikgoz.newsapp.datasource

import androidx.paging.PagingSource
import com.osmanacikgoz.newsapp.api.NewsServices
import com.osmanacikgoz.newsapp.const.Const
import com.osmanacikgoz.newsapp.model.entity.Article

class NewsDataSource(
    private val newsServices: NewsServices,
    private val searchParam: String
) : PagingSource<Int, Article>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val currentLoadingPageKey = params.key ?: 1
            val response = newsServices.getNews(searchParam, currentLoadingPageKey, Const.CONST_PAGE)
            val data = response.body()?.articles ?: emptyList()

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            LoadResult.Page(
                data = data,
                prevKey = prevKey,
                nextKey = if(data.isNullOrEmpty()) null else currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}