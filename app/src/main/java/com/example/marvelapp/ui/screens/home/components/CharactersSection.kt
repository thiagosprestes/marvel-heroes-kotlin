package com.example.marvelapp.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.marvelapp.BuildConfig
import com.example.marvelapp.data.entity.Character
import com.example.marvelapp.ui.components.TextComponent
import com.example.marvelapp.ui.theme.PrimaryBlack
import com.example.marvelapp.ui.theme.PrimaryGrey
import com.example.marvelapp.ui.theme.PrimaryRed
import com.example.marvelapp.ui.theme.PrimaryWhite

@Composable
fun CharactersSection(
    characters: List<Character>,
    title: String,
    navHostController: NavController
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextComponent(
                text = title,
                fontStyle = MaterialTheme.typography.headlineLarge,
                color = PrimaryRed,
            )
            TextComponent(
                text = "Ver tudo",
                fontStyle = MaterialTheme.typography.bodySmall,
                color = PrimaryGrey
            )
        }
        LazyRow(
            contentPadding = PaddingValues(
                start = 24.dp,
                top = 16.dp,
                end = 8.dp,
                bottom = 48.dp
            ), modifier = Modifier.fillMaxWidth()
        ) {
            items(characters.toList()) { item ->
                Row(
                    modifier = Modifier
                        .padding(
                            start = 0.dp,
                            top = 0.dp,
                            end = 16.dp,
                            bottom = 0.dp,
                        )
                        .width(140.dp)
                        .height(230.dp)
                        .clickable {
                            navHostController.navigate("CHARACTER/${item.id}/${item.type}")
                        }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        AsyncImage(
                            model = "${BuildConfig.BASE_URL}${item.imagePath}",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(16.dp)),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                        )
                        Box(
                            Modifier
                                .size(230.dp, 140.dp)
                                .background(
                                    brush = Brush.verticalGradient(
                                        listOf(Color.Transparent, PrimaryBlack),
                                        0f,
                                        300f,
                                    ),
                                    shape = RoundedCornerShape(
                                        bottomStart = 16.dp,
                                        bottomEnd = 16.dp
                                    )
                                )
                        )
                        Column(
                            Modifier.padding(all = 12.dp)
                        ) {
                            TextComponent(
                                text = item.alterEgo,
                                fontStyle = MaterialTheme.typography.labelSmall,
                                color = PrimaryWhite,
                                modifier = Modifier.padding(vertical = 2.dp)
                            )
                            TextComponent(
                                text = item.name,
                                fontStyle = MaterialTheme.typography.titleSmall,
                                color = PrimaryWhite
                            )
                        }
                    }
                }
            }
        }
    }
}