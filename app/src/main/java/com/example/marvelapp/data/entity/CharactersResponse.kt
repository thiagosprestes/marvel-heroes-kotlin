package com.example.marvelapp.data.entity

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    val heroes: List<Character>,
    val villains: List<Character>,
    @SerializedName("anti-heroes")
    val antiheroes: List<Character>,
    val aliens: List<Character>,
    val humans: List<Character>
)
