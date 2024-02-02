package com.mohammedfares.consumemoviesapi.domain.models

data class AuthRequest(
    val password: String,
    val userName: String
)