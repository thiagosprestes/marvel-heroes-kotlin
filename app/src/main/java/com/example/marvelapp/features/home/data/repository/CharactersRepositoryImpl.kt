package com.example.marvelapp.features.home.data.repository

import com.example.marvelapp.core.data.model.character.Character
import com.example.marvelapp.core.data.model.response.CharactersResponse
import com.example.marvelapp.features.home.domain.datasource.CharactersDataSource
import com.example.marvelapp.features.home.domain.repository.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val dataSource: CharactersDataSource
) : CharactersRepository {
    override suspend fun getCharacters(): CharactersResponse {
        return dataSource.getCharacters()
    }

    override suspend fun getCharacter(id: String, type: String): Character {
        return dataSource.getCharacter(id, type)
    }
}