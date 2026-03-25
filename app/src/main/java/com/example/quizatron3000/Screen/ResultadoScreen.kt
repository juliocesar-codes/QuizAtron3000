package com.example.quizatron3000.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizatron3000.R

@Composable
fun ResultadoScreen(navController: NavController, score: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .size(80.dp)
                .padding(vertical = 10.dp, horizontal = 0.dp),
            painter = painterResource(R.drawable.quiz),
            contentDescription = "QUIZ logo"
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 10.dp)
                .background(Color(95, 209, 240, 255)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .background(Color(105, 206, 156, 255))
                    .width(200.dp)
                    .height(30.dp)
                    .border(1.dp, color = Color.Black),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Bom trabalho!",
                    fontSize = 20.sp
                )
            }
            Text(
                text = "Você acertou $score de 3 perguntas",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(20.dp)
            )
        }
        OutlinedButton(
            onClick = {
                navController.navigate("inicial")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(243, 212, 49, 255)
            )
        ) {
            Text(
                text = "JOGAR NOVAMENTE",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
        }
    }
}