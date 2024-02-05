package com.example.marvelapp.ui.repository

import com.example.marvelapp.BuildConfig
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

    private val timestamp = Timestamp(System.currentTimeMillis()).time.toString()
    private val apiKey = BuildConfig.PUBLIC_KEY
    private val privateKey = BuildConfig.PRIVATE_KEY

    private fun generateHash(): String {
        val input = "$timestamp$privateKey$apiKey"
        val md5 = MessageDigest.getInstance("MD5")
        val md5ToBigInt = BigInteger(1, md5.digest(input.toByteArray()))

        return md5ToBigInt.toString(16).padStart(31, '0')
    }

    suspend fun getCharacters(): Flow<ResourceState<CharactersResponse>> {
        return flow {
            emit(ResourceState.Loading())
            val response = charactersDataSource.getCharacters(
                apikey = apiKey,
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