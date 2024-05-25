package com.example.marvelapp.core.data.utils

sealed class RequestState<T> {
    class Loading<T> : RequestState<T>()
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error<T>(val data: String) : RequestState<T>()
}