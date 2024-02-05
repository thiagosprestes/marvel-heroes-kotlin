package com.example.marvelapp.data.entity

import com.google.gson.annotations.SerializedName

data class Hero(
    val name: String,
    val alterEgo: String,
    val imagePath: String,
    val biography: String,
    @SerializedName("characteristics")
    val caracteristics: Characteristics,
    val abilities: Abilities,
    val movies: Array<String>,
    val id: String,
)
