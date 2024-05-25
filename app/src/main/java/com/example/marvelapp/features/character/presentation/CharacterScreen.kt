package com.example.marvelapp.features.character.presentation

import android.app.Activity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marvelapp.core.data.model.character.CharacterType
import com.example.marvelapp.core.presentation.ErrorComposable
import com.example.marvelapp.core.presentation.Loading
import com.example.marvelapp.core.presentation.model.ComposableState
import com.example.marvelapp.features.character.presentation.components.Container

@Composable
fun CharacterScreen(
    characterViewModel: CharacterViewModel = hiltViewModel(),
    navController: NavController,
    id: String,
    type: String
) {
    val view = LocalView.current

    val window = (view.context as Activity).window
    window.statusBarColor = Color.Black.toArgb()
    WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false

    val state by characterViewModel.state.collectAsState()

    LaunchedEffect(key1 = true) {
        characterViewModel.getCharacter(id, type = CharacterType.valueOf(type))
    }

    when (state.composableState) {
        ComposableState.LOADING -> {
            Loading()
        }

        ComposableState.DEFAULT -> {
            Container(
                character = state.character,
                navController = navController
            )
        }

        ComposableState.ERROR -> {
            ErrorComposable(onRetry = {})
        }
    }
}