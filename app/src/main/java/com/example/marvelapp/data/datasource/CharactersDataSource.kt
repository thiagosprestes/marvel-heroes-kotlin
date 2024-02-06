package com.example.marvelapp.data.datasource

import com.example.marvelapp.data.entity.Character
import com.example.marvelapp.data.entity.CharactersResponse
import retrofit2.Response

interface CharactersDataSource {
    suspend fun getCharacters(): Response<CharactersResponse>

    suspend fun getCharacter(
        id: String,
        type: String
    ): Response<Character>
}