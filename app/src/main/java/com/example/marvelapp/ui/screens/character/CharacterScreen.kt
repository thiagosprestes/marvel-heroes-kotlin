package com.example.marvelapp.ui.screens.character

import android.util.Log
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.marvelapp.ResourceState
import com.example.marvelapp.data.entity.Character
import com.example.marvelapp.ui.components.Loader
import com.example.marvelapp.ui.screens.home.TAG
import com.example.marvelapp.ui.viewmodel.CharacterViewModel

@Composable
fun CharacterScreen(
    id: String,
    type: String,
    characterViewModel: CharacterViewModel = hiltViewModel()
) {
    val character by characterViewModel.character.collectAsState()



    characterViewModel.getCharacter(
        id = id,
        type = type
    )

    Surface {
        Surface {
            when (character) {
                is ResourceState.Loading -> {
                    Log.d(TAG, "Loading")
                    Loader()
                }

                is ResourceState.Success -> {
                    val response = (character as ResourceState.Success<Character>).data
                    Log.d(TAG, "Success ${response.name}")

                }

                is ResourceState.Error -> {
                    Log.d(
                        TAG, "Error $character"
                    )
                }

                else -> {}
            }
        }
    }
}