package com.example.marvelapp.features.home.domain.repository

import com.example.marvelapp.core.data.model.character.Character
import com.example.marvelapp.core.data.model.response.CharactersResponse

interface CharactersRepository {
    suspend fun getCharacters(): CharactersResponse

    suspend fun getCharacter(id: String, type: String): Character
}