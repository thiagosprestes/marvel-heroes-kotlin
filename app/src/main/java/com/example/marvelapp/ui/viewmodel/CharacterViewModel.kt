package com.example.marvelapp.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.ResourceState
import com.example.marvelapp.data.model.character.Character
import com.example.marvelapp.ui.repository.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _character: MutableStateFlow<ResourceState<Character>> =
        MutableStateFlow(ResourceState.Loading())
    val character: StateFlow<ResourceState<Character>> = _character

    init {
        val id = savedStateHandle.get<String>("id")
        val type = savedStateHandle.get<String>("type")

        getCharacter(id = id!!, type = type!!)
    }

    private fun getCharacter(
        id: String,
        type: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            charactersRepository.getCharacter(
                id = id, type = type
            ).collectLatest { response ->
                _character.value = response
            }
        }
    }
}