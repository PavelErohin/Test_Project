package com.example.test_project.di

import com.example.test_project.screens.detail.data.DetailRepository
import com.example.test_project.screens.main.data.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit


@Module
@InstallIn(ViewModelComponent::class)
object DetailModule {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        disneyService: Retrofit
    ): DetailRepository {
        return DetailRepository(disneyService)
    }
}