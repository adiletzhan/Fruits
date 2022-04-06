package com.example.fruits.domain.models

data class Fruit(
    val family: String,
    val genus: String,
    val id: Int,
    val name: String,
    val nutritions: Nutritions,
    val order: String
)