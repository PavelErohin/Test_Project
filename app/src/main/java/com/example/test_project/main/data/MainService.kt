package com.example.test_project.main.data

import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {

  @GET("main")
  suspend fun getMain(@Query("id") id: Int): MainData

  @GET("blog")
  suspend fun getBlog(@Query("id") id: Int, @Query("format") format: String): Blog
}