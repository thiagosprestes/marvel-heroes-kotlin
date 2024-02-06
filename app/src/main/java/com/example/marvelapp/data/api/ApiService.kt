package com.example.marvelapp.data.api

import com.example.marvelapp.data.entity.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("home-characters")
    suspend fun getCharacters(): Response<CharactersResponse>
}