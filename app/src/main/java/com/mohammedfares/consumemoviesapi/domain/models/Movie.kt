package com.mohammedfares.consumemoviesapi.domain.models

data class Movie(
    val date: String,
    val desc: String,
    val id: Int,
    val image: String,
    val name: String,
    val price: Double,
    val stars: Int
)