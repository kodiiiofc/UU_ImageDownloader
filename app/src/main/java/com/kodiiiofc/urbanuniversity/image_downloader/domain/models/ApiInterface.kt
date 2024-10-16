package com.kodiiiofc.urbanuniversity.image_downloader.domain.models

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("woof.json")
    suspend fun getRandomDog() : Response<ApiData>
}