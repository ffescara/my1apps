package com.ffescara.my1apps.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ffescara.my1apps.model.Article
import com.ffescara.my1apps.network.Api
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    var newsUiState: List<Article> by mutableStateOf(listOf())

    init {
        //println("test")
        getListNews()
    }

    fun getListNews() {
        viewModelScope.launch {
            val response = Api.newsAPIService.GetTopHeadline()
            val articles = response.articles

            articles.forEach{ article: Article ->
                println(article.toString())
                Log.d("response", article.toString())
            }

            newsUiState = response.articles
        }
    }
}