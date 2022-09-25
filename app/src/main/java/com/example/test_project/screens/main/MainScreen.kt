package com.example.test_project.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.test_project.screens.detail.presentation.DetailViewModel
import com.example.test_project.screens.main.views.MainViewDisplay
import com.example.test_project.screens.main.views.MainViewLoading
import com.example.test_project.screens.main.models.MainViewState
import com.example.test_project.screens.main.views.MainViewDisplay
import com.example.test_project.screens.main.views.MainViewError
import com.example.test_project.screens.main.views.MainViewLoading

@ExperimentalFoundationApi
@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    navController: NavController
) {
  val viewState = mainViewModel.mainViewState.observeAsState()
  when (val state = viewState.value) {
    MainViewState.Loading -> MainViewLoading()
    MainViewState.Error -> MainViewError { }
    is MainViewState.Display -> MainViewDisplay(
      viewState = state, navController
    )
    else -> {}
  }
}