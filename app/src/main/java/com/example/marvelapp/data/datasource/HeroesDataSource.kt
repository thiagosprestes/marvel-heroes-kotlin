package com.example.marvelapp.data.datasource

import com.example.marvelapp.data.entity.Hero
import retrofit2.Response

interface HeroesDataSource {
    suspend fun getHeroes(): Response<List<Hero>>
}