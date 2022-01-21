package com.example.treenity_kotlin.data.api

import com.example.treenity_kotlin.BuildConfig
import com.example.treenity_kotlin.data.model.ImageItem

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers


interface ImageApiService {


    @Headers("Accept-Version: v1", "Authorization: Client-ID ${BuildConfig.CLIENT_ID_TEST}")
    @GET(BuildConfig.END_POINT_TEST)
    suspend fun getAllImages(): Response<List<ImageItem>>

}