package com.example.marvelapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvelapp.core.data.model.character.CharacterType
import com.example.marvelapp.features.character.presentation.CharacterScreen
import com.example.marvelapp.features.home.presentation.HomeScreen

@Composable
fun AppNavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {
        composable(Routes.HOME_SCREEN) {
            HomeScreen(navController = navController)
        }
        composable(Routes.CHARACTER_SCREEN) {
            val id = it.arguments?.getString("id")
            val type = it.arguments?.getString("type")

            CharacterScreen(navController = navController, id = id!!, type = type!!)
        }
    }
}