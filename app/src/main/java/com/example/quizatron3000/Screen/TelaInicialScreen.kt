package com.example.quizatron3000.Screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizatron3000.R

@Composable
fun TelaInicialScreen(navController: NavController) {
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

//        Variavel nome que vai guardar o que foi inserido no Input
        var nome by remember {
            mutableStateOf("")
        }

//        Input que vai ser inserido o nome
        OutlinedTextField(value = nome, onValueChange = {
            novoTexto -> nome = novoTexto
        })

//        Botão para navegar para a página do Quiz
        Button(
            onClick = {

                navController.navigate("quiz/$nome")
            }
        ) {Text(text = "COMECAR!") }
    }
}