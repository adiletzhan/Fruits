package com.example.fruits.domain

import com.example.fruits.domain.models.Fruit
import retrofit2.Response
import retrofit2.http.GET

interface FruitsAPI {
    @GET("/fruit/all")
    fun getAllFruits(): Response<List<Fruit>>


}