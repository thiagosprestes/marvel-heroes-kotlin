package com.example.marvelapp.features.character.domain.usecase

import com.example.marvelapp.core.data.model.character.Character
import com.example.marvelapp.core.data.model.character.CharacterType
import com.example.marvelapp.core.data.utils.RequestState
import com.example.marvelapp.features.character.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetCharacterUseCase {
    suspend operator fun invoke(id: String, type: CharacterType): Flow<RequestState<Character>>
}

class GetCharacterUseCaseImpl @Inject constructor(
    private val repository: CharacterRepository
) : GetCharacterUseCase {
    override suspend fun invoke(id: String, type: CharacterType): Flow<RequestState<Character>> = flow {
        try {
            val parsedType = when(type) {
                CharacterType.HERO -> "heroes"
                CharacterType.VILLAIN -> "villains"
                CharacterType.ANTIHERO -> "antiheroes"
                CharacterType.ALIEN -> "aliens"
                CharacterType.HUMAN -> "humans"
            }

            val response = repository.getCharacter(id, parsedType)

            emit(RequestState.Success(response))
        } catch (e: Exception) {
            emit(RequestState.Error(e.localizedMessage ?: "Error in flow"))
        }
    }
}