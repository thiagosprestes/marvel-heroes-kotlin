package com.example.marvelapp.data.datasource

import com.example.marvelapp.data.api.ApiService
import com.example.marvelapp.data.entity.Character
import com.example.marvelapp.data.entity.CharacterType
import com.example.marvelapp.data.entity.CharactersResponse
import retrofit2.Response
import javax.inject.Inject

class CharactersDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : CharactersDataSource {
    override suspend fun getCharacters(): Response<CharactersResponse> {
        return apiService.getCharacters()
    }

    override suspend fun getCharacter(id: String, type: String): Response<Character> {
        val parsedType: String = when (type) {
            CharacterType.HERO.toString() -> "heroes"
            CharacterType.VILLAIN.toString() -> "villains"
            CharacterType.ANTIHERO.toString() -> "anti-heroes"
            CharacterType.ALIEN.toString() -> "aliens"
            CharacterType.HUMAN.toString() -> "humans"
            else -> ""
        }

        return apiService.getCharacter(id = id, type = parsedType)
    }
}