package com.example.marvelapp.ui.repository

import com.example.marvelapp.ResourceState
import com.example.marvelapp.data.datasource.HeroesDataSource
import com.example.marvelapp.data.entity.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val charactersDataSource: HeroesDataSource
) {
//    suspend fun getHeroes(): Response<HeroesResponse> {
//        return heroesDataSource.getHeroes()
//    }

    suspend fun getHeroes(): Flow<ResourceState<List<Hero>>> {
        return flow {
            emit(ResourceState.Loading())
            val response = charactersDataSource.getHeroes()

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