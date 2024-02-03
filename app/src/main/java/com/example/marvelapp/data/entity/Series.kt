package com.example.marvelapp.data.entity

data class Series(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)