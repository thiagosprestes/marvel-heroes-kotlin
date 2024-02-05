package com.example.marvelapp.data.datasource

import com.example.marvelapp.data.api.ApiService
import com.example.marvelapp.data.entity.Hero
import retrofit2.Response
import javax.inject.Inject

class HeroesDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : HeroesDataSource {
    override suspend fun getHeroes(): Response<List<Hero>> {
        return apiService.getHeroes()
    }
}