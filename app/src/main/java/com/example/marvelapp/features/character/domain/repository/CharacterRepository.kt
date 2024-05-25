package com.example.marvelapp.features.character.domain.repository

import com.example.marvelapp.core.data.model.character.Character
import com.example.marvelapp.core.data.model.character.CharacterType

interface CharacterRepository {
    suspend fun getCharacter(id: String, type: String): Character
}