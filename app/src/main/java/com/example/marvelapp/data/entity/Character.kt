package com.example.marvelapp.data.entity

import com.google.gson.annotations.SerializedName

enum class CharacterType {
    @SerializedName("hero")
    HERO,
    @SerializedName("villain")
    VILLAIN,
    @SerializedName("antihero")
    ANTIHERO,
    @SerializedName("alien")
    ALIEN,
    @SerializedName("human")
    HUMAN
}

data class Character(
    val name: String,
    val alterEgo: String,
    val imagePath: String,
    val id: String,
    val type: CharacterType,
    val biography: String? = null,
    val caracteristics: Characteristics? = null,
    val abilities: Abilities? = null,
    val movies: Array<String>? = null
)
