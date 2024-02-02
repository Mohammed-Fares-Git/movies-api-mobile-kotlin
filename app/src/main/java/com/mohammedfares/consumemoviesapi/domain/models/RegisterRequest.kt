package com.mohammedfares.consumemoviesapi.domain.models

data class RegisterRequest(
    val firstName: String,
    val image: String,
    val lastName: String,
    val password: String,
    val userName: String
)