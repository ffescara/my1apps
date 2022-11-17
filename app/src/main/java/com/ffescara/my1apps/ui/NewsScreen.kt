package com.ffescara.my1apps.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ffescara.my1apps.model.Article
import com.ffescara.my1apps.model.Source

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewsApp(listArticle: List<Article>) {

    Scaffold(topBar = {
        TopAppBar() {
            Icon(Icons.Rounded.Menu, contentDescription = "Icon")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Berita Terkini")
    }
    }) {
        LazyColumn {
            items(listArticle) { article ->
                NewsCard(article = article)
            }
        }
    }



}

@Composable
fun NewsCard(article: Article) {

    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Column() {
            AsyncImage(
                model = article.urlToImage,
                contentDescription = "news image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = article.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsCardPreview() {
    NewsCard(
        article = Article(
            author = "Firdan",
            content = "",
            source = Source(id = "", name = ""),
            description = "",
            publishedAt = "",
            title = "",
            url = "",
            urlToImage = ""
        )
    )
}