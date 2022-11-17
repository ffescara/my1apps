package com.ffescara.my1apps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ffescara.my1apps.ui.NewsApp
import com.ffescara.my1apps.ui.NewsViewModel
import com.ffescara.my1apps.ui.theme.My1appsTheme

class MainActivity : ComponentActivity() {
    val newsModel by viewModels<NewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApp(newsModel.newsUiState)
        }
    }
}

@Composable
fun Greeting(name: String) {
    val newsViewModel: NewsViewModel = viewModel()
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    My1appsTheme {
        Greeting("Android")
    }
}
