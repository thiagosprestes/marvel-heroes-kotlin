package com.example.marvelapp.ui.screens.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvelapp.R
import com.example.marvelapp.ResourceState
import com.example.marvelapp.data.entity.CharactersResponse
import com.example.marvelapp.ui.components.Loader
import com.example.marvelapp.ui.components.TextComponent
import com.example.marvelapp.ui.screens.TAG
import com.example.marvelapp.ui.theme.PrimaryBlack
import com.example.marvelapp.ui.theme.PrimaryGrey
import com.example.marvelapp.ui.theme.PrimaryRed

@Composable
fun Container(
    charactersResponse: ResourceState<CharactersResponse>?
) {
    Surface {
        Content()
        when (charactersResponse) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Loading")
                Loader()
            }

            is ResourceState.Success -> {
                val response = charactersResponse.data
                Log.d(TAG, "Success ${response.data}")
            }

            is ResourceState.Error -> {
                Log.d(
                    TAG, "Error $charactersResponse"
                )
            }

            else -> {}
        }
    }
}

@Composable
fun Content() {
//    LazyColumn {
////        items(response.data.results) { item ->
////            Text(text = item.name, modifier = Modifier.padding(innerPadding))
////        }
//
//    }
    val imageSlider = listOf(
        painterResource(id = R.drawable.ic_launcher_background),
        painterResource(id = R.drawable.marvel_logo),
    )

    Column(
    ) {
        Header()
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                modifier = Modifier
            ) {
                TextComponent(
                    text = "Bem vindo ao Marvel Heroes",
                    fontStyle = MaterialTheme.typography.bodyMedium,
                    color = PrimaryGrey
                )
                TextComponent(
                    text = "Escolha o seu personagem",
                    fontStyle = MaterialTheme.typography.titleMedium,
                    color = PrimaryBlack
                )
            }
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 32.dp, 0.dp, 48.dp)
                ) {
                    CharactersTypeListItem(icon = R.drawable.hero, type = CharacterType.HERO)
                    CharactersTypeListItem(icon = R.drawable.villain, type = CharacterType.VILLAIN)
                    CharactersTypeListItem(
                        icon = R.drawable.antihero, type = CharacterType.ANTIHERO
                    )
                    CharactersTypeListItem(icon = R.drawable.alien, type = CharacterType.ALIEN)
                    CharactersTypeListItem(icon = R.drawable.human, type = CharacterType.HUMAN)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextComponent(
                        text = "Hérois",
                        fontStyle = MaterialTheme.typography.headlineLarge,
                        color = PrimaryRed
                    )
                    TextComponent(
                        text = "Ver tudo",
                        fontStyle = MaterialTheme.typography.headlineLarge,
                        color = PrimaryGrey
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ContainerPreview() {
    Container(
        charactersResponse = null
    )
}