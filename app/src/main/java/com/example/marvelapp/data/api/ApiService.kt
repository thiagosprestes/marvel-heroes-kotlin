package com.example.marvelapp.data.api

import com.example.marvelapp.data.entity.Hero
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("heroes")
    suspend fun getHeroes(): Response<List<Hero>>
}