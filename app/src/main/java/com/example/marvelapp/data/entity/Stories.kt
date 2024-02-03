package com.example.marvelapp.data.entity

data class Stories(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)