package com.example.marvelapp.features.character.presentation

import androidx.lifecycle.ViewModel
import com.example.marvelapp.core.data.model.character.CharacterType
import com.example.marvelapp.core.data.utils.RequestState
import com.example.marvelapp.core.presentation.model.ComposableState
import com.example.marvelapp.features.character.domain.usecase.GetCharacterUseCase
import com.example.marvelapp.features.character.presentation.model.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CharacterState())
    val state: StateFlow<CharacterState> = _state.asStateFlow()

    suspend fun getCharacter(id:String, type: CharacterType) {
        val response = getCharacterUseCase.invoke(id = id.toString(), type = type)

        response.collectLatest { requestState ->
            when (requestState) {
                is RequestState.Success -> {
                    _state.value = CharacterState(
                        character = requestState.data,
                        composableState = ComposableState.DEFAULT
                    )
                }

                is RequestState.Error -> {
                    _state.value = CharacterState(composableState = ComposableState.ERROR)
                }
                is RequestState.Loading -> {
                    _state.value = CharacterState(composableState = ComposableState.LOADING)
                }
            }
        }
    }
}