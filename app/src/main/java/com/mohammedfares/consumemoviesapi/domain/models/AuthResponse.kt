package com.mohammedfares.consumemoviesapi.domain.models

data class AuthResponse(
    val firstName: String,
    val image: String,
    val jwtToken: String,
    val lastName: String,
    val userName: String
)