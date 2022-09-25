package com.example.test_project.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.test_project.main.views.MainViewDisplay
import com.example.test_project.main.views.MainViewLoading
import com.example.test_project.main.models.MainViewState
import com.example.test_project.main.views.MainViewError

@ExperimentalFoundationApi
@Composable
fun MainScreen(
  mainViewModel: MainViewModel
) {
  val viewState = mainViewModel.mainViewState.observeAsState()

  when (val state = viewState.value) {
    MainViewState.Loading -> MainViewLoading()
    MainViewState.Error -> MainViewError {
      /*mainViewModel.obtainEvent(MainScreenEvent.ReloadScreen)*/
    }
    is MainViewState.Display -> MainViewDisplay(
      viewState = state
    )
    else -> {}//throw NotImplementedError("Unexpected main state")
  }

/*  LaunchedEffect(key1 = viewState, block = {
    mainViewModel.obtainEvent(event = MainScreenEvent.EnterScreen)
  })*/
}