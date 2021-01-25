package com.hemanth.newsapp.di


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.hemanth.newsapp.AppController
import com.hemanth.newsapp.data.ApiService
import com.hemanth.newsapp.data.db.ArticleDatabase
import com.hemanth.newsapp.data.repository.MainRepository
import com.hemanth.newsapp.data.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


private const val BASE_URL = "https://newsapi.org"

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCurrencyApi(): ApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)


    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context) = ArticleDatabase(context)

    @Singleton
    @Provides
    fun provideMainRepository(api: ApiService, db: ArticleDatabase): MainRepository =
        MainRepositoryImpl(api, db)

}