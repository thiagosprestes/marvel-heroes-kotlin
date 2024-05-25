package com.example.marvelapp.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvelapp.R
import com.example.marvelapp.data.model.character.CharacterType
import com.example.marvelapp.ui.theme.gradientBlue
import com.example.marvelapp.ui.theme.gradientGreen
import com.example.marvelapp.ui.theme.gradientPink
import com.example.marvelapp.ui.theme.gradientPurple
import com.example.marvelapp.ui.theme.gradientRed


@Composable
fun CharactersTypeListItem(
    icon: Int,
    type: CharacterType
) {
    val characterTypeGradient = when (type) {
        CharacterType.HERO -> listOf(gradientBlue[0], gradientBlue[1])
        CharacterType.VILLAIN -> listOf(gradientRed[0], gradientRed[1])
        CharacterType.ANTIHERO -> listOf(gradientPurple[0], gradientPurple[1])
        CharacterType.ALIEN -> listOf(gradientGreen[0], gradientGreen[1])
        CharacterType.HUMAN -> listOf(gradientPink[0], gradientPink[1])
    }

    Box(
        modifier = Modifier
            .size(56.dp)
            .clip(CircleShape)
            .background(
                brush = Brush.verticalGradient(
                    colors = characterTypeGradient
                )
            )
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(32.dp)
        )
    }
}

@Preview
@Composable
fun CharactersTypeListItemPreview() {
    CharactersTypeListItem(icon = R.drawable.villain, type = CharacterType.VILLAIN)
}