package com.example.marvelapp.data.datasource

import com.example.marvelapp.data.model.character.Character
import com.example.marvelapp.data.model.response.CharactersResponse
import retrofit2.Response

interface CharactersDataSource {
    suspend fun getCharacters(): Response<CharactersResponse>

    suspend fun getCharacter(
        id: String,
        type: String
    ): Response<Character>
}