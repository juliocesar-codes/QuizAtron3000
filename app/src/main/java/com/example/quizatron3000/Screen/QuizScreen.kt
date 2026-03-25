package com.example.quizatron3000.Screen

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizatron3000.R
import com.example.quizatron3000.componentes.perguntas

@Composable


fun QuizScreen(navController: NavController) {

    var indiceAtual by remember {
        mutableStateOf(0)
    }

    var score by remember {
        mutableStateOf(0)
    }

    val perguntaAtual = perguntas[indiceAtual]


    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(242, 142, 202, 255))
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .size(50.dp),
            painter = painterResource(R.drawable.quiz),
            contentDescription = "QUIZ logo"
        )
        Row(
            modifier = Modifier
                .width(250.dp)
                .padding(10.dp)
                .background(Color(105, 206, 156, 255))
                .border(BorderStroke(1.dp, color = Color.Black)),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Pergunta 1 de 3",
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
        Card(
            modifier = Modifier
                .width(350.dp)
                .height(350.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = perguntaAtual.pergunta,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp)
                )

                perguntaAtual.opcoes.forEachIndexed { index, opcao ->
                    OutlinedButton (
                        onClick = {
                        if (index == perguntaAtual.respostaCorreta){
                            score++
                        }
                            if (indiceAtual < perguntas.size - 1){
                                indiceAtual++
                            }else{
                                navController.navigate("resultado/$score")
                            }
                        },
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(250, 250, 250, 255),
                        ),
                    ) {
                        Text(
                            text = opcao,
                            color = Color.Black,
                            fontWeight = FontWeight.Normal,
                            fontSize = 20.sp
                        )
                    }
                }
                }

            }


        }
    }