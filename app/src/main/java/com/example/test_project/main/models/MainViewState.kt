package com.example.test_project.main.models

sealed class MainViewState {
  object Loading : MainViewState()
  object Error : MainViewState()
  data class Display(
    val title: String,
    val items: List<BlogsContent.BlogItem>
  ) : MainViewState()
}
