package com.example.test_project.screens.detail.data

import com.example.test_project.screens.main.data.MainData
import retrofit2.http.GET
import retrofit2.http.Query

interface DetailService {

    @GET("blog-info")
    suspend fun getBlogInfo(@Query("id") id: Int, @Query("blog_id") blogId: Int): Detail

}