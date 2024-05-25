package com.example.marvelapp.core.data.mapper

import com.example.marvelapp.BuildConfig

fun String.toUrl(): String = "${BuildConfig.BASE_URL}/$this"