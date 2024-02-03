package com.example.marvelapp.ui.screens.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvelapp.R
import com.example.marvelapp.ResourceState
import com.example.marvelapp.data.entity.CharactersResponse
import com.example.marvelapp.ui.components.FontSize
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
                    TAG,
                    "Error $charactersResponse"
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
                    size = FontSize.HOME_SUBTITLE,
                    color = PrimaryGrey
                )
                TextComponent(
                    text = "Escolha o seu personagem",
                    size = FontSize.HOME_TITLE,
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
                    CharactersTypeListItem(icon = R.drawable.antihero, type = CharacterType.ANTIHERO)
                    CharactersTypeListItem(icon = R.drawable.alien, type = CharacterType.ALIEN)
                    CharactersTypeListItem(icon = R.drawable.human, type = CharacterType.HUMAN)
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