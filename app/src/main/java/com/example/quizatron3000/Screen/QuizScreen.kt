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


fun QuizScreen(navController: NavController, nome: String) {

//    Aqui tem 3 variaveis importantes para fazer o quiz

//    O indiceAtual se refere a qual pergunta está no momento (1 a 3)
    var indiceAtual by remember {
        mutableStateOf(0)
    }

//    O score representa a quantia de perguntas acertadas
    var score by remember {
        mutableStateOf(0)
    }

//   E a perguntaAtual se refere ao array da pergunta que está sendo mostrado no momento
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

//            indiceAtual vale 0, então o projeto começa inserindo +1 para mostrar a 1 pergunta
            Text(
                text = "Pergunta ${indiceAtual+1} de 3",
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
                }

            /* Aqui é onde o quiz funciona, começamos com um forEach do array criado no arquivo "Question.kt"
            Onde para cada opção da perguntaAtual, é criado um botão que representa cada alternativa da pergunta.
            * */

                perguntaAtual.opcoes.forEachIndexed { index, opcao ->
                    OutlinedButton (
                        onClick = {

                            /* Ao clicar no botão acontece duas verificações, a primeira verifica se o botão clicado
                            é a alternativa correta, caso for, o score recebe +1, caso contrário, não recebe nada
                            * */

                        if (index == perguntaAtual.respostaCorreta){
                            score++
                        }

                            /*A segunda requisição é para verificar se há mais perguntas ou não, caso haja, ao clicar no botão
                            é aberta a próxima pergunta, caso contrário, vai para a página de resultado.
                            * */

                            if (indiceAtual < perguntas.size - 1){
                                indiceAtual++
                            }else{
                                navController.navigate("resultado/$nome/$score")
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