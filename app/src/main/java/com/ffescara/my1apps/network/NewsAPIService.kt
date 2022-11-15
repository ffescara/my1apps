package com.ffescara.my1apps.network

import com.ffescara.my1apps.model.NewsData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://newsapi.org/v2/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface NewsAPIService {
    @GET("top-headlines?country=us&apiKey=6bca55d0c42d4ce7993692ee340f1e26")
    suspend fun GetTopHeadline(): NewsData

}

object Api {
    val newsAPIService: NewsAPIService by lazy {
        retrofit.create(NewsAPIService::class.java)
    }
}