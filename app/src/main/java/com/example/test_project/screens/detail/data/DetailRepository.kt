package com.example.test_project.screens.detail.data

import retrofit2.HttpException
import retrofit2.Retrofit
import javax.inject.Inject

class DetailRepository @Inject constructor(network: Retrofit) {
    private val api = network.create(DetailService::class.java)

    suspend fun getDetail(id: Int): Detail? {
        val main = try {
            api.getBlogInfo(ID, id)
        } catch (e: HttpException) {
            return null
        }
        return if (main.success) main
        else null
    }

    companion object {
        const val BLOG_ID = 167
        const val ID = 117
    }
}