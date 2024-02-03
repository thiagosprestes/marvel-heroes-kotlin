package com.example.marvelapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.marvelapp.R

val gilroyFontFamily = FontFamily(
    Font(R.font.gilroy_heavy, FontWeight.Black),
    Font(R.font.gilroy_bold, FontWeight.Bold),
    Font(R.font.gilroy_medium, FontWeight.Medium),
    Font(R.font.gilroy_semibold, FontWeight.SemiBold),
    Font(R.font.gilroy_regular, FontWeight.Normal),
)

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 40.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 32.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 20.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
    ),
)