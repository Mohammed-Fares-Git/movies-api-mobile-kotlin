package com.mohammedfares.consumemoviesapi.domain.repositories

import com.mohammedfares.consumemoviesapi.domain.models.AuthRequest
import com.mohammedfares.consumemoviesapi.domain.models.AuthResponse
import com.mohammedfares.consumemoviesapi.domain.models.Movie
import com.mohammedfares.consumemoviesapi.domain.models.RegisterRequest

interface IRepository {
    suspend fun registerUser(registerRequest: RegisterRequest): AuthResponse
    suspend fun authenticateUser(authRequest: AuthRequest): AuthResponse
    suspend fun getAllMovies(): List<Movie>
}