package com.example.marvelapp.features.home.data.repository

import com.example.marvelapp.core.data.model.response.CharactersResponse
import com.example.marvelapp.core.domain.datasource.CharactersDataSource
import com.example.marvelapp.features.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val dataSource: CharactersDataSource
) : HomeRepository {
    override suspend fun getCharacters(): CharactersResponse {
        return dataSource.getCharacters()
    }

}