package com.example.marvelapp.features.home.data.mapper

import com.example.marvelapp.core.data.mapper.toUrl
import com.example.marvelapp.core.data.model.character.Character
import com.example.marvelapp.features.home.data.model.HomeCharacter

fun List<Character>.toHomeCharacter(): List<HomeCharacter> = this.map {
    HomeCharacter(
        id = it.id,
        name = it.name,
        alterEgo = it.alterEgo,
        path = it.imagePath.toUrl(),
        type = it.type
    )
}