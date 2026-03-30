package com.example.quizatron3000

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.quizatron3000.Screen.QuizScreen
import com.example.quizatron3000.Screen.TelaInicialScreen
import com.example.quizatron3000.Screen.ResultadoScreen
import com.example.quizatron3000.ui.theme.QuizAtron3000Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizAtron3000Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Aqui está sendo criado o controlador
                    val navController = rememberNavController()

//                    Aqui se defini as rotas, começando a navegaçao pela inicial
                    NavHost(
                        navController = navController,
                        startDestination = "inicial",
                    ){
//                        Cada composable representa uma página do projeto
                        composable(
                            route = "inicial",
                        ){
                            TelaInicialScreen(navController)
                        }
                        composable(
                            route = "quiz/{nome}",
//                            Aqui é adicionado os argumentos que é passado de uma tela para outra
                            arguments = listOf(navArgument("nome"){
                                type = NavType.StringType
                            })
                        ){ backStackEntry ->
                            val nome = backStackEntry.arguments?.getString("nome") ?: ""

                            QuizScreen(
                                navController = navController,
                                nome = nome
                            )
                        }
                        composable(
                            route = "resultado/{nome}/{score}",
                            arguments = listOf(
                                navArgument("score"){ type = NavType.IntType },
                                navArgument("nome"){ type = NavType.StringType }
                            )
//                            BackStackEntry é o parametro para o Lambda
                        ){ backStackEntry ->
                            val score = backStackEntry.arguments?.getInt("score") ?: 0
                            val nome = backStackEntry.arguments?.getString("nome") ?: ""

                            ResultadoScreen(
                                navController,
                                score,
                                nome)
                        }
                    }
                }
            }
        }
    }
}
