package com.example.marvelapp.ui.screens.character.components

import android.icu.util.Calendar
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.marvelapp.BuildConfig
import com.example.marvelapp.R
import com.example.marvelapp.ResourceState
import com.example.marvelapp.data.entity.Abilities
import com.example.marvelapp.data.entity.Character
import com.example.marvelapp.data.entity.CharacterType
import com.example.marvelapp.data.entity.Characteristics
import com.example.marvelapp.data.entity.Height
import com.example.marvelapp.data.entity.Weight
import com.example.marvelapp.ui.components.Loader
import com.example.marvelapp.ui.components.TextComponent
import com.example.marvelapp.ui.screens.home.TAG
import com.example.marvelapp.ui.theme.PrimaryBlack
import com.example.marvelapp.ui.theme.PrimaryDark
import com.example.marvelapp.ui.theme.PrimaryWhite

@Composable
fun Container(character: ResourceState<Character>) {
    Surface(modifier = Modifier.background(PrimaryDark)) {
        when (character) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Loading")
                Loader()
            }

            is ResourceState.Success -> {
                val response = character.data
                Log.d(TAG, "Success ${response.name}")
                Content(character = character.data)
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
    character: Character
) {
    val calendar = Calendar.getInstance()
    val fullYear = calendar.get(Calendar.YEAR)

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Row(modifier = Modifier.height(812.dp)) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomStart
            ) {
                AsyncImage(
                    model = "${BuildConfig.BASE_URL}/${character.imagePath}",
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
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
                        text = character.name,
                        fontStyle = MaterialTheme.typography.headlineMedium,
                        color = PrimaryWhite
                    )
                    TextComponent(
                        text = character.alterEgo,
                        fontStyle = MaterialTheme.typography.titleLarge,
                        color = PrimaryWhite,
                    )
                    CharacterInfo(
                        age = fullYear - character.caracteristics?.birth?.toInt()!!,
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
    }
    Box {
        Row {
            IconButton(onClick = {}) {
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
            movies = arrayOf(""),
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
        )
    )
}