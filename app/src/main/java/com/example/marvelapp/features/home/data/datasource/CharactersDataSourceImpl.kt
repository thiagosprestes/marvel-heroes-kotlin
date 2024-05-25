package com.example.marvelapp.features.home.data.datasource

import com.example.marvelapp.core.data.api.CharacterService
import com.example.marvelapp.core.data.model.character.Character
import com.example.marvelapp.core.data.model.response.CharactersResponse
import com.example.marvelapp.features.home.domain.datasource.CharactersDataSource
import retrofit2.Response
import javax.inject.Inject

class CharactersDataSourceImpl @Inject constructor(
    private val apiService: CharacterService
) : CharactersDataSource {
    override suspend fun getCharacters(): CharactersResponse {
        return apiService.getCharacters()
    }

    override suspend fun getCharacter(id: String, type: String): Character {
        return apiService.getCharacter(id = id, type = type)
    }
}