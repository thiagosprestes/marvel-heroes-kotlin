package com.example.marvelapp.ui.screens.character.components

import android.icu.util.Calendar
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
import com.example.marvelapp.core.presentation.TextComponent
import com.example.marvelapp.core.presentation.theme.PrimaryWhite

@Composable
fun CharacterInfo(
    birth: Int,
    weight: Int,
    height: String,
    universe: String
) {
    val calendar = Calendar.getInstance()
    val fullYear = calendar.get(Calendar.YEAR)

    val age = fullYear - birth

    val unknownAge = age == fullYear

    val ageLabel = if(unknownAge) "????" else "$age anos"

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
                text = "$ageLabel",
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