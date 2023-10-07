package com.example.myapplication.models

import com.example.myapplication.models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)