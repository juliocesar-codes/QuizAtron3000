package com.example.quizatron3000.componentes

data class Question(
    val pergunta: String,
    val opcoes: List<String>,
    val respostaCorreta: Int
)

val perguntas = listOf(
    Question("Qual a capital do Brasil?",listOf("SP","MG","Brasilia","BH"),2),
    Question("Qual a cor do Céu?",listOf("Azul","Verde","Rosa","Vermelho"),0),
    Question("Quanto é 2 + 2?",listOf("5","6","3","4"),3)
)
