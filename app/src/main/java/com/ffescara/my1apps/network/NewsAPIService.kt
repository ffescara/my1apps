package com.ffescara.my1apps.network

import com.ffescara.my1apps.model.NewsData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://run.mocky.io/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface NewsAPIService {
    @GET("everything?q=bitcoin&apiKey=6bca55d0c42d4ce7993692ee340f1e26")
    suspend fun GetEverything(): String

    @GET("v3/4a6b4002-e45f-4ffd-8b9e-508419c6ff0a")
    suspend fun GetTopHeadline(): NewsData
}

object Api {
    val newsAPIService: NewsAPIService by lazy {
        retrofit.create(NewsAPIService::class.java)
    }
}