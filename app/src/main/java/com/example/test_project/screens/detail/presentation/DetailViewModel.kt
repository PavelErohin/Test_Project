package com.example.test_project.screens.detail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_project.screens.detail.data.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val detailRepository: DetailRepository
) : ViewModel() {

    private val userId: String = checkNotNull(savedStateHandle["id"])
    val detailLiveData = MutableLiveData<Blog>()

    init {
        launch(userId.toInt())
    }

    private fun launch(id: Int) {
        viewModelScope.launch {
            val result = detailRepository.getDetail(id)
            if (result != null) {
                detailLiveData.value = Blog(
                    date = result.data.date,
                    image = result.data.image.lg,
                    title = result.data.title,
                    content = result.data.content
                )
            } else {

            }
        }
    }

}