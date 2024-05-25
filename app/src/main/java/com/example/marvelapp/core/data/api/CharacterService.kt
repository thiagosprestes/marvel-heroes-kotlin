package com.example.marvelapp.core.data.api

import com.example.marvelapp.core.data.model.character.Character
import com.example.marvelapp.core.data.model.response.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {
    @GET("home-characters")
    suspend fun getCharacters(): CharactersResponse

    @GET("{type}/{id}")
    suspend fun getCharacter(
        @Path("type") type: String,
        @Path("id") id: String
    ): Character
}