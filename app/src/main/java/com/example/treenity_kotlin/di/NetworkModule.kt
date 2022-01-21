package com.example.treenity_kotlin.di

import com.example.treenity_kotlin.BuildConfig
import com.example.treenity_kotlin.data.api.ImageApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideRetrofitInstance(): ImageApiService =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_TEST)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImageApiService::class.java)

}