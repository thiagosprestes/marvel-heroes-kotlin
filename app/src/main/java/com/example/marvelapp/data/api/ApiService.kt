package com.example.marvelapp.data.api

import com.example.marvelapp.data.entity.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.sql.Timestamp

interface ApiService {
    @GET("characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): Response<CharactersResponse>

}