package com.ffescara.my1apps.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ffescara.my1apps.model.Article
import com.ffescara.my1apps.network.Api
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    init {
        getListNews()
    }

    fun getListNews() {
        viewModelScope.launch {
            val response = Api.newsAPIService.GetTopHeadline()
            val articles = response.articles

            articles.forEach{ article: Article ->
                Log.d("response", "tes")
                Log.d("response", article.toString())
            }
        }
    }
}