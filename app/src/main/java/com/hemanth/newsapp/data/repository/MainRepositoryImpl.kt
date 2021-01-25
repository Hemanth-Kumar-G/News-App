package com.hemanth.newsapp.data.repository

import com.hemanth.newsapp.data.ApiService
import com.hemanth.newsapp.data.db.ArticleDatabase
import com.hemanth.newsapp.data.model.Article

class MainRepositoryImpl(
    private val apiService: ApiService,
    private val db: ArticleDatabase
) : MainRepository {

    override suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        apiService.getBreakingNews(countryCode, pageNumber)

    override suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        apiService.searchForNews(searchQuery, pageNumber)

    override suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    override fun getSavedNews() = db.getArticleDao().getAllArticles()

    override suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}