package com.example.marvelapp.core.domain.datasource

import com.example.marvelapp.core.data.model.character.Character
import com.example.marvelapp.core.data.model.character.CharacterType
import com.example.marvelapp.core.data.model.response.CharactersResponse

interface CharactersDataSource {
    suspend fun getCharacters(): CharactersResponse

    suspend fun getCharacter(
        id: String,
        type: String
    ): Character
}