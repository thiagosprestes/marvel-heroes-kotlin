package com.example.marvelapp.ui.screens.character.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.marvelapp.BuildConfig
import com.example.marvelapp.ResourceState
import com.example.marvelapp.data.model.character.Abilities
import com.example.marvelapp.data.model.character.Character
import com.example.marvelapp.data.model.character.CharacterType
import com.example.marvelapp.data.model.character.Characteristics
import com.example.marvelapp.data.model.character.Height
import com.example.marvelapp.data.model.character.Weight
import com.example.marvelapp.ui.components.Loader
import com.example.marvelapp.ui.components.TextComponent
import com.example.marvelapp.ui.screens.home.TAG
import com.example.marvelapp.ui.theme.PrimaryBlack
import com.example.marvelapp.ui.theme.PrimaryDark
import com.example.marvelapp.ui.theme.PrimaryWhite

@Composable
fun Container(character: ResourceState<Character>, navController: NavController) {
    Surface(modifier = Modifier.background(PrimaryDark)) {
        when (character) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Loading")
                Loader()
            }

            is ResourceState.Success -> {
                val response = character.data
                Log.d(TAG, "Success ${response.name}")
                Content(character = character.data, navController=navController)
            }

            is ResourceState.Error -> {
                Log.d(
                    TAG, "Error $character"
                )
            }
        }
    }
}

@Composable
fun Content(
    character: Character,
    navController: NavController?
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(PrimaryBlack)
    ) {
        Row(modifier = Modifier.height(812.dp)) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomStart
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(
                            "${BuildConfig.BASE_URL}/${character.imagePath}"
                        )
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,

                    )
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(Color.Transparent, PrimaryBlack),
                                600f
                            ),
                        )
                )
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    TextComponent(
                        text = character.alterEgo,
                        fontStyle = MaterialTheme.typography.headlineMedium,
                        color = PrimaryWhite
                    )
                    TextComponent(
                        text = character.name,
                        fontStyle = MaterialTheme.typography.titleLarge,
                        color = PrimaryWhite,
                    )
                    CharacterInfo(
                        birth = character.caracteristics?.birth?.toInt()!!,
                        weight = character.caracteristics.weight.value,
                        height = character.caracteristics.height.value,
                        universe = character.caracteristics.universe
                    )
                    TextComponent(
                        text = character.biography!!,
                        fontStyle = MaterialTheme.typography.bodySmall,
                        color = PrimaryWhite
                    )
                }
            }
        }
        Column(
            modifier = Modifier.padding(
                start = 24.dp,
                top = 8.dp,
                end = 32.dp,
                bottom = 48.dp
            )
        ) {
            TextComponent(
                text = "Habilidades",
                fontStyle = MaterialTheme.typography.headlineLarge,
                color = PrimaryWhite,
            )
            AbilityRow(label = "Força", level = character.abilities?.force!!)
            AbilityRow(label = "Inteligência", level = character.abilities.intelligence)
            AbilityRow(label = "Agilidade", level = character.abilities.agility)
            AbilityRow(label = "Resistência", level = character.abilities.endurance)
            AbilityRow(label = "Velocidade", level = character.abilities.velocity)
        }
        Column(
            modifier = Modifier.padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 48.dp)
        ) {
            TextComponent(
                text = "Filmes e séries",
                fontStyle = MaterialTheme.typography.headlineLarge,
                color = PrimaryWhite,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            MoviesRow(movies = character.movies!!)
        }
    }
    Box {
        Row {
            IconButton(onClick = {
                navController?.popBackStack()
            }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null, tint = PrimaryWhite)
            }
        }
    }
}

@Preview
@Composable
fun ContentPreview() {
    Content(
        character = Character(
            name = "Homem Aranha",
            alterEgo = "Peter Parker",
            imagePath = "chars/spider-man.png",
            id = "12345",
            type = CharacterType.HERO,
            movies = arrayOf("1", "2"),
            abilities = Abilities(
                force = 70,
                intelligence = 65,
                agility = 90,
                endurance = 60,
                velocity = 80
            ),
            biography = "Em Forest Hills, Queens, Nova York, o estudante de ensino médio, Peter Parker, é um cientista orfão que vive com seu tio Ben e tia May. Ele é mordido por uma aranha radioativa em uma exposição científica e adquire a agilidade e a força proporcional de um aracnídeo. Junto com a super força, Parker ganha a capacidade de andar nas paredes e tetos. Através de sua habilidade nativa para a ciência, ele desenvolve um aparelho que o permitir lançar teias artificiais. Inicialmente buscando capitalizar suas novas habilidades, Parker cria um traje e, como Homem Aranha, torna-se uma estrela de televisão.",
            caracteristics = Characteristics(
                birth = "1990",
                weight = Weight(value = 78, unity = "kg"),
                height = Height(value = 1.8.toString(), unity = "meters"),
                universe = "Terra 616"
            ),
        ),
        navController = null
    )
}