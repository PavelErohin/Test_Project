package com.example.test_project.main.domain

data class MainScreenState(val title: String, val blogs: List<BlogItem>) {
    data class BlogItem(
        val id: Int,
        val image: String,
        var title: String,
        val subtitle: String,
    )
}

data class Buttons(
    val title: String,
    val url: String
)