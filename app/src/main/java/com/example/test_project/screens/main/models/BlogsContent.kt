package com.example.test_project.screens.main.models

data class BlogsContent(val title: String, val blogs: List<BlogItem>) {
  data class BlogItem(
    val id: Int,
    val image: String,
    val title: String,
    val subtitle: String,
  )
}
