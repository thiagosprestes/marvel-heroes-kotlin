package com.example.marvelapp.features.home.presentation.model

import com.example.marvelapp.core.presentation.model.ComposableState
import com.example.marvelapp.features.home.data.model.HomeCharacter

data class HomeState(
    val composableState: ComposableState = ComposableState.DEFAULT,
    val characters: List<HomeCharacter> = emptyList()
)