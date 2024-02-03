package com.example.marvelapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.marvelapp.ui.screens.components.Container
import com.example.marvelapp.ui.viewmodel.HomeViewModel

const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val charactersResponse by homeViewModel.characters.collectAsState()

    Container(
        charactersResponse = charactersResponse
    )
}

