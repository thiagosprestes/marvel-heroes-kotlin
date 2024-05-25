package com.example.marvelapp.features.character.presentation.model

import com.example.marvelapp.core.data.model.character.Abilities
import com.example.marvelapp.core.data.model.character.Character
import com.example.marvelapp.core.data.model.character.CharacterType
import com.example.marvelapp.core.presentation.model.ComposableState

data class CharacterState(
    val composableState: ComposableState = ComposableState.LOADING,
    val character: Character = Character(
        name = "",
        alterEgo = "",
        imagePath = "",
        id = "",
        type = CharacterType.HERO,
        biography = "",
        caracteristics = null,
        abilities = Abilities(
            force = 0,
            intelligence = 0,
            agility = 0,
            endurance = 0,
            velocity = 0,
        ),
        movies = arrayOf("")
    )
)