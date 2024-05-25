package com.example.marvelapp.ui.screens.character.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.marvelapp.core.presentation.TextComponent
import com.example.marvelapp.core.presentation.theme.PrimaryDark
import com.example.marvelapp.core.presentation.theme.PrimaryWhite

@Composable
fun AbilityRow(
    label: String,
    level: Int
) {
    val numOfBars = 45

    fun getAbilityBarLevel(item: Int): Color {
        val shouldRenderCompletedAbilityBar = item <= (level * numOfBars) / 100

        if (shouldRenderCompletedAbilityBar) return PrimaryWhite

        return PrimaryDark
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(
            start = 0.dp,
            top = 24.dp,
            end = 0.dp,
            bottom = 0.dp
        )
    ) {
        TextComponent(
            text = label,
            fontStyle = MaterialTheme.typography.labelMedium,
            color = PrimaryWhite,
            modifier = Modifier.width(70.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    top = 0.dp,
                    end = 0.dp,
                    bottom = 0.dp
                )
        ) {
            for (i in 1..numOfBars) {
                Column(
                    modifier = Modifier
                        .height(10.dp)
                        .width(1.dp)
                        .background(
                            getAbilityBarLevel(item = i)
                        )
                ) {}
            }
        }
    }
}