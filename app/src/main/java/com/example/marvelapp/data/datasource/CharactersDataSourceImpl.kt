package com.example.marvelapp.data.datasource

import com.example.marvelapp.data.api.ApiService
import com.example.marvelapp.data.entity.Character
import com.example.marvelapp.data.entity.CharactersResponse
import retrofit2.Response
import javax.inject.Inject

class CharactersDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : CharactersDataSource {
    override suspend fun getCharacters(): Response<CharactersResponse> {
        return apiService.getCharacters()
    }
}