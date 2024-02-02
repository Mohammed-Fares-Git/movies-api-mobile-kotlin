package com.mohammedfares.consumemoviesapi.data

import com.mohammedfares.consumemoviesapi.data.remote.AuthService
import com.mohammedfares.consumemoviesapi.data.remote.MovieService
import com.mohammedfares.consumemoviesapi.domain.models.AuthRequest
import com.mohammedfares.consumemoviesapi.domain.models.AuthResponse
import com.mohammedfares.consumemoviesapi.domain.models.Movie
import com.mohammedfares.consumemoviesapi.domain.models.RegisterRequest
import com.mohammedfares.consumemoviesapi.domain.repositories.IRepository
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    val api: MovieService,
    val auth: AuthService
): IRepository {
    override suspend fun registerUser(registerRequest: RegisterRequest): AuthResponse {
        return auth.registerUser(registerRequest)
    }

    override suspend fun authenticateUser(authRequest: AuthRequest): AuthResponse {
        return auth.authenticateUser(authRequest)
    }

    override suspend fun getAllMovies(): List<Movie> {
        return api.getAllMovies()
    }

}