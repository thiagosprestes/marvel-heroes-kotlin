package com.example.marvelapp.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marvelapp.ui.screens.home.components.Container
import com.example.marvelapp.ui.viewmodel.HomeViewModel

const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {
    val characters by homeViewModel.characters.collectAsState()

    Container(
        characters = characters,
        navController = navController
    )
}

