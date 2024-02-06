package com.example.marvelapp.data.api

import com.example.marvelapp.data.entity.Character
import com.example.marvelapp.data.entity.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("home-characters")
    suspend fun getCharacters(): Response<CharactersResponse>

    @GET("{type}/{id}")
    suspend fun getCharacter(
        @Path("type") type: String,
        @Path("id") id: String
    ): Response<Character>
}