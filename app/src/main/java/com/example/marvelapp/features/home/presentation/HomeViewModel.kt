package com.example.marvelapp.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.core.data.utils.RequestState
import com.example.marvelapp.core.presentation.model.ComposableState
import com.example.marvelapp.features.home.domain.useCase.GetCharactersUseCase
import com.example.marvelapp.features.home.presentation.model.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getCharacters()
        }
    }

    private suspend fun getCharacters() {
        val response = getCharactersUseCase.invoke()

        response.collectLatest { requestState ->
            when (requestState) {
                is RequestState.Loading -> {
                    _state.value = HomeState(composableState = ComposableState.LOADING)
                }

                is RequestState.Success -> {
                    _state.value = HomeState(
                        composableState = ComposableState.DEFAULT,
                        characters = requestState.data
                    )
                }

                is RequestState.Error -> {
                    _state.value = HomeState(
                        composableState = ComposableState.ERROR
                    )
                }

            }
        }
    }
}
