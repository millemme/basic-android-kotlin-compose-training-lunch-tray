package com.example.cityapp.model

data class Category(
    val name: String,
    var image: Int,
    val recommendations: List<Recommendation>
)

