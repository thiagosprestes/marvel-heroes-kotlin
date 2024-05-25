package com.example.marvelapp.core.data.model.response

import com.example.marvelapp.core.data.model.character.Character
import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    val heroes: List<Character>,
    val villains: List<Character>,
    @SerializedName("anti-heroes")
    val antiheroes: List<Character>,
    val aliens: List<Character>,
    val humans: List<Character>
)
