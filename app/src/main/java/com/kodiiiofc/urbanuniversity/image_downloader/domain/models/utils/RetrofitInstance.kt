package com.kodiiiofc.urbanuniversity.image_downloader.domain.models.utils

import com.kodiiiofc.urbanuniversity.image_downloader.domain.models.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(Utils.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}