package com.example.marvelapp.features.home.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marvelapp.core.presentation.Loading
import com.example.marvelapp.core.presentation.model.ComposableState
import com.example.marvelapp.features.home.presentation.components.Container

const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by homeViewModel.state.collectAsState()

    when(state.composableState) {
        ComposableState.LOADING -> {
            Loading()
        }
        ComposableState.DEFAULT -> {
            Container(characters = state.characters, navController = navController)
        }
        ComposableState.ERROR -> {
            Text(text = "VRAU")
        }
    }
}

