package com.example.marvelapp.data.entity

data class Events(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)