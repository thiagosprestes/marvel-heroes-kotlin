package com.example.marvelapp.ui.screens.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvelapp.R
import com.example.marvelapp.ResourceState
import com.example.marvelapp.data.entity.Character
import com.example.marvelapp.data.entity.CharactersResponse
import com.example.marvelapp.ui.components.Loader
import com.example.marvelapp.ui.components.TextComponent
import com.example.marvelapp.ui.screens.TAG
import com.example.marvelapp.ui.theme.PrimaryBlack
import com.example.marvelapp.ui.theme.PrimaryGrey
import com.example.marvelapp.ui.theme.PrimaryWhite

@Composable
fun Container(
    characters: ResourceState<CharactersResponse>?
) {
    Surface {
        when (characters) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Loading")
                Loader()
            }

            is ResourceState.Success -> {
                val response = characters.data
                Log.d(TAG, "Success $response")

                Content(response = response)
            }

            is ResourceState.Error -> {
                Log.d(
                    TAG, "Error $characters"
                )
            }

            else -> {}
        }
    }
}

@Composable
fun Content(
    response: CharactersResponse
) {
    Column(
        modifier = Modifier
            .background(PrimaryWhite)
            .verticalScroll(rememberScrollState())
    ) {
        Header()
        Column(
            modifier = Modifier.padding(start = 24.dp, top = 24.dp, end = 24.dp)
        ) {
            TextComponent(
                text = "Bem vindo ao Marvel Heroes",
                fontStyle = MaterialTheme.typography.bodyMedium,
                color = PrimaryGrey,
            )
            TextComponent(
                text = "Escolha o seu personagem",
                fontStyle = MaterialTheme.typography.titleMedium,
                color = PrimaryBlack
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp, top = 32.dp, end = 0.dp, bottom = 48.dp)
            ) {
                CharactersTypeListItem(icon = R.drawable.hero, type = CharacterType.HERO)
                CharactersTypeListItem(
                    icon = R.drawable.villain, type = CharacterType.VILLAIN
                )
                CharactersTypeListItem(
                    icon = R.drawable.antihero, type = CharacterType.ANTIHERO
                )
                CharactersTypeListItem(icon = R.drawable.alien, type = CharacterType.ALIEN)
                CharactersTypeListItem(icon = R.drawable.human, type = CharacterType.HUMAN)
            }
        }
        CharactersSection(characters = response.heroes, title = "Hérois")
        CharactersSection(characters = response.villains, title = "Vilões")
        CharactersSection(characters = response.antiheroes, title = "anti-hérois")
        CharactersSection(characters = response.aliens, title = "Alienígenas")
        CharactersSection(characters = response.humans, title = "Humanos")
    }
}

@Preview
@Composable
fun ContainerPreview() {
    Content(
        response = CharactersResponse(
            heroes = listOf(
                Character(
                    name = "Homem Aranha",
                    alterEgo = "Peter Parker",
                    imagePath = "chars/spider-man.png",
                )
            ),
            villains = emptyList(),
            aliens = emptyList(),
            antiheroes = emptyList(),
            humans = emptyList()
        )
    )
}