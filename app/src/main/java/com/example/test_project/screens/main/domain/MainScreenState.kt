package com.example.test_project.screens.main.domain

data class MainScreenState(val title: String, val blogs: List<BlogItem>) {
  data class BlogItem(
    val id: Int,
    val image: String,
    var title: String,
    val subtitle: String,
  )
}/*(
  val buttons: List<Buttons>,
  val content: List<Content>
) {
  data class Content(
    val title: String,
    val isOpenable: Boolean,
    val Blog: BlogsContent
  )

  data class Buttons(
    val title: String,
    val url: String
  )
}*/