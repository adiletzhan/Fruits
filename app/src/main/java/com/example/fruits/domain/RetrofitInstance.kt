package com.example.fruits.domain

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    val api: FruitsAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FruitsAPI::class.java)
    }
}