package com.example.test_project.main.data

import retrofit2.HttpException
import retrofit2.Retrofit
import javax.inject.Inject

class MainRepository @Inject constructor(network: Retrofit) {

  private val api = network.create(MainService::class.java)

  private suspend fun getMain(): MainData? {
    val main = try {
      api.getMain(ID)
    } catch (e: HttpException) {
      return null
    }
    return if (main.success) api.getMain(ID)
    else null
  }

  /*suspend fun mappedMain(): MainScreenState? {
    val main = getMain()
    return if (main != null) {
      return MainScreenState(
        buttons = main.data.buttons.map {
          MainScreenState.Buttons(
            title = it.title,
            url = it.url
          )
        },
        content = main.data.content.map {
          MainScreenState.Content(
            isOpenable = it.template.type == OPENABLE_TYPE,
            title = it.title,
            url = it.url
          )
        }
      )
    } else {
      null
    }
  }*/

  companion object {
    const val OPENABLE_TYPE = "blog"
    const val ID = 117
  }
}