package com.example.marvelapp.features.home.domain.useCase

import com.example.marvelapp.core.data.model.character.Character
import com.example.marvelapp.core.data.utils.RequestState
import com.example.marvelapp.features.home.data.mapper.toHomeCharacter
import com.example.marvelapp.features.home.data.model.HomeCharacter
import com.example.marvelapp.features.home.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetCharactersUseCase {
    fun mappingCharacters(characters: List<Character>): List<HomeCharacter>

    suspend operator fun invoke(): Flow<RequestState<List<HomeCharacter>>>

}

class GetCharactersUseCaseImpl @Inject constructor(
    private val repository: CharactersRepository
) : GetCharactersUseCase {

    override fun mappingCharacters(characters: List<Character>): List<HomeCharacter> =
        characters.toHomeCharacter()


    override suspend fun invoke(): Flow<RequestState<List<HomeCharacter>>> = flow {
        try {
            val response = repository.getCharacters()

            val aliens = mappingCharacters(response.aliens)
            val heroes = mappingCharacters(response.heroes)
            val villains = mappingCharacters(response.villains)
            val antiHeroes = mappingCharacters(response.antiheroes)

            val charactersList = setOf(aliens, heroes, villains, antiHeroes).flatten()

            emit(RequestState.Success(charactersList))
        } catch (e: Exception) {
            emit(RequestState.Error(e.localizedMessage ?: "Error in flow"))
        }
    }
}