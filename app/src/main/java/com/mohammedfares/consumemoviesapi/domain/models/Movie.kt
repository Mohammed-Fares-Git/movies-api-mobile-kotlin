package com.mohammedfares.consumemoviesapi.domain.models

data class Movie(
    val id: Int?,
    val name: String,
    val desc: String,
    val price: Double,
    val image: String,
    val date: String,
    val stars: Int
)