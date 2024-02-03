package com.example.marvelapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.ResourceState
import com.example.marvelapp.data.entity.CharactersResponse
import com.example.marvelapp.ui.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
    private val _characters: MutableStateFlow<ResourceState<CharactersResponse>> =
        MutableStateFlow(ResourceState.Loading())
    val characters: StateFlow<ResourceState<CharactersResponse>> = _characters

    init {
        // getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            homeRepository.getCharacters().collectLatest { response ->
                _characters.value = response
            }
        }
    }

    companion object {
        const val TAG = "HomeViewModel"
    }
}
