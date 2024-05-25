package com.example.marvelapp.features.home.domain.repository

import com.example.marvelapp.core.data.model.response.CharactersResponse

interface HomeRepository {
    suspend fun getCharacters(): CharactersResponse
}