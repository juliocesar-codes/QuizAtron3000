package com.example.quizatron3000.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.quizatron3000.R

@Composable
fun QuizScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(90.dp),
            painter = painterResource(R.drawable.quiz),
            contentDescription = "QUIZ logo"
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(text = "Pergunta 1 de 3")
        }
        Card(
            modifier = Modifier
                .width(350.dp)
        ) {
            Text(text = "teste")
            Button(onClick = {}) {
                Text("Text")
            }
            Button(onClick = {}) {
                Text("Text")
            }
            Button(onClick = {}) {
                Text("Text")
            }
            Button(onClick = {}) {
                Text("Text")
            }

        }
    }
}