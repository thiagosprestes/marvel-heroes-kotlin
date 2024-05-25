package com.example.marvelapp.core.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marvelapp.core.presentation.theme.PrimaryRed
import com.example.marvelapp.core.presentation.theme.PrimaryWhite

@Composable
fun Error(onRetry: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            TextComponent(
                text = "Ops, algo deu errado!",
                fontSize = 28.sp,
                fontStyle = MaterialTheme.typography.headlineLarge,
                color = PrimaryWhite,
            )
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onRetry() },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryRed),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(text = "Tentar novamente")
        }
    }
}

@Preview
@Composable
private fun ErrorPreview() {
    Error(onRetry = {})
}