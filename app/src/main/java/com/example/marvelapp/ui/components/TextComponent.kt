package com.example.marvelapp.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextComponent(
    text: String,
    fontStyle: TextStyle,
    color: Color
) {
    Text(
        text = text,
        style = fontStyle,
        color = color
    )
}

@Preview
@Composable
fun TextComponentPreview() {
    TextComponent(
        text = "Olá, mundo!!",
        fontStyle = MaterialTheme.typography.headlineLarge,
        color = Color.White
    )
}