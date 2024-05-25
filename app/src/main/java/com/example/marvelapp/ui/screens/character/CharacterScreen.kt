package com.example.marvelapp.ui.screens.character

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marvelapp.features.home.presentation.HomeViewModel
import com.example.marvelapp.ui.screens.character.components.Container

@Composable
fun CharacterScreen(
    characterViewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {
    val view = LocalView.current

    val window = (view.context as Activity).window
    window.statusBarColor = Color.Black.toArgb()
    WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false

//    val character by characterViewModel.character.collectAsState()

//    Container(character = {}, navController = navController)
}