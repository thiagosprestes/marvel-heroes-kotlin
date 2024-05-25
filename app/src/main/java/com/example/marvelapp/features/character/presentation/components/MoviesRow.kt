package com.example.marvelapp.features.character.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.marvelapp.BuildConfig

@Composable
fun MoviesRow(
    movies: Array<String>
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 0.dp,
                top = 24.dp,
                end = 0.dp,
                bottom = 0.dp
            ),
        contentPadding = PaddingValues(
            start = 24.dp,
            top = 0.dp,
            end = 8.dp,
            bottom = 0.dp
        )
    ) {
        items(movies.toList()) { item ->
            AsyncImage(
                model = "${BuildConfig.BASE_URL}/${item}",
                contentDescription = null,
                modifier = Modifier
                    .width(140.dp)
                    .height(230.dp)
                    .padding(
                        start = 0.dp,
                        top = 0.dp,
                        end = 16.dp,
                        bottom = 0.dp,
                    ),
                contentScale = ContentScale.Crop
            )
        }
    }
}