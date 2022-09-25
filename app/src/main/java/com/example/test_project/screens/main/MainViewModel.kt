package com.example.test_project.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_project.screens.main.models.BlogsContent
import com.example.test_project.screens.main.data.MainRepository
import com.example.test_project.screens.main.models.MainViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val repository: MainRepository
) : ViewModel()/*, EventHandler<MainScreenEvent> */ {

  private val _mainViewState: MutableLiveData<MainViewState> =
    MutableLiveData(MainViewState.Loading)
  val mainViewState: LiveData<MainViewState> = _mainViewState

  init {
    val blogs = listOf(
      BlogsContent.BlogItem(
        233,
        "https://cdn2.rsttur.ru/photos/blog-233-700-400-80.webp?v=1663567527",
        "Чем заняться в Приморье осенью",
        "Отдых в Приморье осенью. Погода в осенние месяцы, виды развлчений, туры и базы отдыха."
      ), BlogsContent.BlogItem(
        291,
        "https://cdn2.rsttur.ru/photos/blog-226-700-400-80.webp?v=1651481009",
        "Альтернатива Букингу! Бронирование отелей, гостиниц и баз отдыха на РСТ",
        "Как забронировать гостиницу, апартаментов и баз отдыха быстро и онлайн на сайт РСТ-тур. Разделы с отелями и базами отдыха на сайте, лучшие места для отдыха в Приморском крае.",
      ), BlogsContent.BlogItem(
        220,
        "https://cdn2.rsttur.ru/photos/blog-233-700-400-80.webp?v=1663567527",
        "Чем заняться в Приморье осенью",
        "Отдых в Приморье осенью. Погода в осенние месяцы, виды развлчений, туры и базы отдыха."
      )
    )
    _mainViewState.postValue(
      MainViewState.Display(
        title = "Блог",
        items = blogs
      )
    )
  }

  /*override fun obtainEvent(event: MainScreenEvent) {
    when (val currentState = _mainViewState.value) {
      is MainViewState.Loading -> reduce(event, currentState)
      is MainViewState.Display -> reduce(event, currentState)
      is MainViewState.Error -> reduce(event, currentState)
    }
  }

  private fun reduce(event: MainScreenEvent, currentState: MainViewState.Loading) {
    when (event) {
      MainScreenEvent.EnterScreen -> fetchHabbitForDate()
      else -> {}
    }
  }

  private fun reduce(event: MainScreenEvent, currentState: MainViewState.Display) {
    when (event) {
      MainScreenEvent.EnterScreen -> fetchHabbitForDate()
*//*      is MainScreenEvent.OnBlogItemClick -> performHabbitClick(
        habbitId = event.blogId
      )*//*
      else -> {}
    }
  }

  private fun reduce(event: MainScreenEvent, currentState: MainViewState.Error) {
    when (event) {
      MainScreenEvent.ReloadScreen -> fetchHabbitForDate(needsToRefresh = true)
      else -> {}
    }
  }*/

  private fun goBlog(blogId: Int) {

  }

  /*private fun fetchHabbitForDate(needsToRefresh: Boolean = false) {
    if (needsToRefresh) {
      _mainViewState.postValue(MainViewState.Loading)
    }

    viewModelScope.launch {
      Log.d("qwe777", "777")
      try {
        //val habbits = useCase.getMain()


        _mainViewState.value = MainViewState.Loading
        _mainViewState.postValue(
          MainViewState.Display(
            title = "Блог",
            items = blogs
          )
        )

      } catch (e: Exception) {
        _mainViewState.postValue(MainViewState.Error)
      }
    }
  }*/
}
