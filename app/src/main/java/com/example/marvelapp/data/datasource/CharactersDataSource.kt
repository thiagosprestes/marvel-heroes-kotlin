package com.example.marvelapp.data.datasource

import com.example.marvelapp.data.entity.CharactersResponse
import retrofit2.Response

interface CharactersDataSource {
    suspend fun getCharacters(
        ts: String, apikey: String, hash: String
    ): Response<CharactersResponse>
}