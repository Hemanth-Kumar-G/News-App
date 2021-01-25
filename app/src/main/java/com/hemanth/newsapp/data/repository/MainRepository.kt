package com.hemanth.newsapp.data.repository

import androidx.lifecycle.LiveData
import com.hemanth.newsapp.data.model.Article
import com.hemanth.newsapp.data.model.NewsResponse
import retrofit2.Response


interface MainRepository {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int): Response<NewsResponse>

    suspend fun searchNews(searchQuery: String, pageNumber: Int): Response<NewsResponse>

    suspend fun upsert(article: Article): Long

    fun getSavedNews(): LiveData<List<Article>>

    suspend fun deleteArticle(article: Article)
}