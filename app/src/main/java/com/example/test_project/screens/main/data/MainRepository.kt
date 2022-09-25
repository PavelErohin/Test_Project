package com.example.test_project.screens.main.data

import retrofit2.HttpException
import retrofit2.Retrofit
import javax.inject.Inject

class MainRepository @Inject constructor(network: Retrofit) {

  private val api = network.create(MainService::class.java)

  suspend fun getMain(): MainData? {
    val main = try {
      api.getMain(ID)
    } catch (e: HttpException) {
      return null
    }
    return if (main.success) main
    else null
  }

  suspend fun getBlog(): Blog? {
    val blog = try {
      api.getBlog(ID, FORMAT)
    } catch (e: HttpException) {
      return null
    }
    return if (blog.success) blog else null
  }

  companion object {
    const val FORMAT = "card"
    const val ID = 117
  }
}