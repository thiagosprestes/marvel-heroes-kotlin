package com.example.marvelapp.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

enum class FontSize {
    PROFILE_TITLE,
    HOME_TITLE,
    CARD_TITLE,
    SECTION_TITLE,
    PROFILE_SUBTITLE,
    HOME_SUBTITLE,
    DESCRIPTION,
    CHARACTERISTIC,
    ABILITY,
    CARD_SUBTITLE
}

@Composable
fun TextComponent(
    text: String,
    size: FontSize,
    color: Color
) {
    val fontStyle = when (size) {
        FontSize.PROFILE_TITLE -> MaterialTheme.typography.titleLarge
        FontSize.HOME_TITLE -> MaterialTheme.typography.titleMedium
        FontSize.CARD_TITLE -> MaterialTheme.typography.titleSmall
        FontSize.SECTION_TITLE -> MaterialTheme.typography.headlineLarge
        FontSize.PROFILE_SUBTITLE -> MaterialTheme.typography.headlineMedium
        FontSize.HOME_SUBTITLE -> MaterialTheme.typography.bodyMedium
        FontSize.DESCRIPTION -> MaterialTheme.typography.bodySmall
        FontSize.CHARACTERISTIC -> MaterialTheme.typography.labelLarge
        FontSize.ABILITY -> MaterialTheme.typography.labelMedium
        FontSize.CARD_SUBTITLE -> MaterialTheme.typography.labelSmall
    }

    Text(
        text = text,
        style = fontStyle,
        color = color
    )
}

@Preview
@Composable
fun TextComponentPreview() {
    TextComponent(text = "Olá, mundo!!", size = FontSize.HOME_SUBTITLE, color = Color.White)
}