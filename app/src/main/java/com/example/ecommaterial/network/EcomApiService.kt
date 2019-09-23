package com.example.ecommaterial.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface EcomApiService {
    @GET("realestate")
    fun getProductList():
            Call<String>
}


object EcomApi {
    val retrofitService : EcomApiService by lazy {
        retrofit.create(EcomApiService::class.java) }
}