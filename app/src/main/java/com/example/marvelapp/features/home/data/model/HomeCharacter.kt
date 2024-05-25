package com.example.marvelapp.features.home.data.model

import com.example.marvelapp.core.data.model.character.CharacterType

data class HomeCharacter(
    val id: String,
    val name: String,
    val alterEgo: String,
    val path: String,
    val type: CharacterType
)