package com.example.test_project.screens.main.domain

import com.example.test_project.main.data.MainRepository
import com.example.test_project.main.models.BlogsContent
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


class MainUseCase @Inject constructor(private val repository: MainRepository) {

    val buttonsFlow = MutableStateFlow<List<Buttons>?>(null)
    val contentsFlow = MutableStateFlow<List<BlogsContent.BlogItem>?>(null)

    suspend fun getMain() {
        val main = repository.getMain()

        if (main != null) {
            buttonsFlow.value = main.data.buttons.map {
                Buttons(
                    title = it.title,
                    url = it.url
                )
            }

            main.data.content.forEach {
                when(it.template.type) {
                    OPENABLE_TYPE -> {
                        contentsFlow.value = repository.getBlog()?.data?.map { blog ->
                            BlogsContent.BlogItem(
                                id = blog.id,
                                image = blog.image.md,
                                title = blog.title,
                                subtitle = blog.subtitle,
                            )
                        } ?: emptyList()
                    }
                }
            }
        }
    }

    companion object {
        const val OPENABLE_TYPE = "blog"
        const val OBJECT_TYPE = "object"
        const val TOUR_TYPE = "tour"
        const val ROOM_TYPE = "room"
    }
}
