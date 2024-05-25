package com.example.marvelapp.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.marvelapp.R
import com.example.marvelapp.core.data.model.character.CharacterType
import com.example.marvelapp.features.home.data.model.HomeCharacter
import com.example.marvelapp.core.presentation.TextComponent
import com.example.marvelapp.core.presentation.theme.PrimaryBlack
import com.example.marvelapp.core.presentation.theme.PrimaryGrey
import com.example.marvelapp.core.presentation.theme.PrimaryWhite

@Composable
fun Container(
    characters: List<HomeCharacter>,
    navController: NavController
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
                    .padding(top = 32.dp, bottom = 48.dp)
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
        CharactersSection(
            characters = characters.filter { it.type == CharacterType.HERO },
            title = "Hérois",
            navHostController = navController
        )
        CharactersSection(
            characters = characters.filter { it.type == CharacterType.VILLAIN },
            title = "Vilões",
            navHostController = navController
        )
        CharactersSection(
            characters = characters.filter { it.type == CharacterType.ANTIHERO },
            title = "Anti-heróis",
            navHostController = navController
        )
        CharactersSection(
            characters = characters.filter { it.type == CharacterType.ALIEN },
            title = "Alienígenas",
            navHostController = navController
        )
    }
}

@Preview
@Composable
fun ContainerPreview() {
//    Container(
//        navController = NavController(),
//        characters = emptyList()
//    )
}