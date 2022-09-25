package com.example.test_project.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
  @Provides
  @Singleton
  fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
      .baseUrl("https://rsttur.ru/api/base-app/")
      .addConverterFactory(GsonConverterFactory.create()).client(
        OkHttpClient.Builder()
          .addInterceptor(HttpLoggingInterceptor().apply {
            level = if (true) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
          }).build()
      )
      .build()
  }
}
