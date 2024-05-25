package com.example.marvelapp.core.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(
    text: String,
    fontStyle: TextStyle,
    color: Color,
    fontSize: TextUnit = 14.sp,
    modifier: Modifier? = Modifier,
) {
    Text(
        text = text,
        style = fontStyle,
        color = color,
        modifier = modifier!!,
        fontSize = fontSize
    )
}

@Preview
@Composable
fun TextComponentPreview() {
    TextComponent(
        text = "Olá, mundo!!",
        fontStyle = MaterialTheme.typography.headlineLarge,
        color = Color.White,
        fontSize = 14.sp,
        modifier = Modifier
    )
}