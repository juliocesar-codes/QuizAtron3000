package com.example.quizatron3000.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizatron3000.R

@Composable
fun TelaInicialScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(95, 209, 240, 255)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.quiz),
            contentDescription = "QUIZ logo",
            modifier = Modifier
                .size(150.dp)
                .padding(vertical = 16.dp)
        )

        Text(
            text = "QUIZATRON 3000",
            fontSize = 24.sp,
        )

        Button(
            onClick = {
                /*TODO*/
            }
        ) {Text(text = "COMECAR!") }
    }
}