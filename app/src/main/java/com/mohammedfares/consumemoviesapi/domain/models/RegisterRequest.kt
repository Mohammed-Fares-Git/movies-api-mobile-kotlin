package com.mohammedfares.consumemoviesapi.domain.models

data class RegisterRequest(
    val firstName: String,
    val lastName: String,
    val userName: String,
    val password: String,
    val image: String
)