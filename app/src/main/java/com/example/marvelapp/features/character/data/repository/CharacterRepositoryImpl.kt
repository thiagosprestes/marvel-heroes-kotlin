package com.example.marvelapp.features.character.data.repository

import com.example.marvelapp.core.data.model.character.Character
import com.example.marvelapp.core.data.model.character.CharacterType
import com.example.marvelapp.features.character.domain.repository.CharacterRepository
import com.example.marvelapp.core.domain.datasource.CharactersDataSource
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val dataSource: CharactersDataSource
) : CharacterRepository {
    override suspend fun getCharacter(id: String, type: String): Character {
        return dataSource.getCharacter(id, type)
    }
}