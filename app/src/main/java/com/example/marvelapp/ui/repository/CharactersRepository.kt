package com.example.marvelapp.ui.repository

import com.example.marvelapp.ResourceState
import com.example.marvelapp.data.datasource.CharactersDataSource
import com.example.marvelapp.data.model.character.Character
import com.example.marvelapp.data.model.response.CharactersResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val charactersDataSource: CharactersDataSource
) {
    suspend fun getCharacters(): Flow<ResourceState<CharactersResponse>> {
        return flow {
            emit(ResourceState.Loading())
            val response = charactersDataSource.getCharacters()

            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error on fetch api"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e.localizedMessage ?: "Error in flow"))
        }
    }

    suspend fun getCharacter(id: String, type: String): Flow<ResourceState<Character>> {
        return flow {
            emit(ResourceState.Loading())
            val response = charactersDataSource.getCharacter(id = id, type = type)

            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error on fetch api"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e.localizedMessage ?: "Error in flow"))
        }
    }
}