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
import com.example.marvelapp.data.entity.Abilities
import com.example.marvelapp.data.entity.Characteristics
import com.example.marvelapp.data.entity.Height
import com.example.marvelapp.data.entity.Hero
import com.example.marvelapp.data.entity.Weight
import com.example.marvelapp.ui.components.Loader
import com.example.marvelapp.ui.components.TextComponent
import com.example.marvelapp.ui.screens.TAG
import com.example.marvelapp.ui.theme.PrimaryBlack
import com.example.marvelapp.ui.theme.PrimaryGrey
import com.example.marvelapp.ui.theme.PrimaryWhite

@Composable
fun Container(
    heroesResponse: ResourceState<List<Hero>>?
) {
    Surface {
        when (heroesResponse) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Loading")
                Loader()
            }

            is ResourceState.Success -> {
                val response = heroesResponse.data
                Log.d(TAG, "Success $response")

                Content(response = response)
            }

            is ResourceState.Error -> {
                Log.d(
                    TAG, "Error $heroesResponse"
                )
            }

            else -> {}
        }
    }
}

@Composable
fun Content(
    response: List<Hero>
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
        CharactersSection(characters = response, title = "Hérois")
    }
}

@Preview
@Composable
fun ContainerPreview() {
    Content(
        response = listOf(
            Hero(
                name = "Homem Aranha",
                alterEgo = "Peter Parker",
                imagePath = "chars/spider-man.png",
                biography = "Em Forest Hills, Queens, Nova York, o estudante de ensino médio, Peter Parker, é um cientista orfão que vive com seu tio Ben e tia May. Ele é mordido por uma aranha radioativa em uma exposição científica e adquire a agilidade e a força proporcional de um aracnídeo. Junto com a super força, Parker ganha a capacidade de andar nas paredes e tetos. Através de sua habilidade nativa para a ciência, ele desenvolve um aparelho que o permitir lançar teias artificiais. Inicialmente buscando capitalizar suas novas habilidades, Parker cria um traje e, como Homem Aranha, torna-se uma estrela de televisão.",
                caracteristics = Characteristics(
                    weight = Weight(
                        value = 78, unity = "kg"
                    ),
                    birth = "1990",
                    height = Height(value = "1.8", "meters"),
                    universe = "Terra 616"
                ),
                abilities = Abilities(
                    force = 70, intelligence = 65, agility = 90, endurance = 60, velocity = 80
                ),
                movies = arrayOf(
                    "movies/captain-america-3.jpg",
                    "movies/spider-man-homecoming.jpg",
                    "movies/avengers-3.jpg",
                    "movies/avengers-4.jpg",
                    "movies/spider-man-far-from-home.jpg"
                ),
                id = "a556"
            )
        )
    )
}