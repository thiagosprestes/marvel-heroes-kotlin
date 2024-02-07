package com.example.marvelapp.ui.screens.character.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.marvelapp.R
import com.example.marvelapp.ui.components.TextComponent
import com.example.marvelapp.ui.theme.PrimaryWhite

@Composable
fun CharacterInfo(
    age: Int,
    weight: Int,
    height: String,
    universe: String
) {
    Row(
        modifier = Modifier
            .padding(
                start = 0.dp,
                top = 48.dp,
                end = 0.dp,
                bottom = 23.dp
            )
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.age),
                contentDescription = null,
                modifier = Modifier.padding(
                    start = 0.dp,
                    top = 0.dp,
                    end = 0.dp,
                    bottom = 12.dp
                )
            )
            TextComponent(
                text = "$age anos",
                fontStyle = MaterialTheme.typography.labelLarge,
                color = PrimaryWhite
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.weight),
                contentDescription = null,
                modifier = Modifier.padding(
                    start = 0.dp,
                    top = 0.dp,
                    end = 0.dp,
                    bottom = 12.dp
                )
            )
            TextComponent(
                text = "${weight}kg",
                fontStyle = MaterialTheme.typography.labelLarge,
                color = PrimaryWhite
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.height),
                contentDescription = null,
                modifier = Modifier.padding(
                    start = 0.dp,
                    top = 0.dp,
                    end = 0.dp,
                    bottom = 12.dp
                )
            )
            TextComponent(
                text = "${height}m",
                fontStyle = MaterialTheme.typography.labelLarge,
                color = PrimaryWhite
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.universe),
                contentDescription = null,
                modifier = Modifier.padding(
                    start = 0.dp,
                    top = 0.dp,
                    end = 0.dp,
                    bottom = 12.dp
                )
            )
            TextComponent(
                text = universe,
                fontStyle = MaterialTheme.typography.labelLarge,
                color = PrimaryWhite
            )
        }
    }
}