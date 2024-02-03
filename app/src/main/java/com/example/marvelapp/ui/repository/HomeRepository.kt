package com.example.marvelapp.ui.repository

import com.example.marvelapp.ResourceState
import com.example.marvelapp.data.datasource.CharactersDataSource
import com.example.marvelapp.data.entity.CharactersResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val charactersDataSource: CharactersDataSource
) {
//    suspend fun getCharacters(): Response<CharactersResponse> {
//        return charactersDataSource.getCharacters()
//    }

    val timestamp = Timestamp(System.currentTimeMillis()).time.toString()
    val API_KEY = ""
    val PRIVATE_KEY = ""

    fun generateHash(): String {
        val input = "$timestamp$PRIVATE_KEY$API_KEY"
        val md5 = MessageDigest.getInstance("MD5")
        return BigInteger(1, md5.digest(input.toByteArray())).toString(16).padStart(31, '0')
    }

    suspend fun getCharacters(): Flow<ResourceState<CharactersResponse>> {
        return flow {
            emit(ResourceState.Loading())
            val response = charactersDataSource.getCharacters(
                apikey = "",
                ts = timestamp,
                hash = generateHash()
            )

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