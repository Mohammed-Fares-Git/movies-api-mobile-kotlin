package com.mohammedfares.consumemoviesapi.data.remote

import com.mohammedfares.consumemoviesapi.domain.models.AuthRequest
import com.mohammedfares.consumemoviesapi.domain.models.AuthResponse
import com.mohammedfares.consumemoviesapi.domain.models.Movie
import com.mohammedfares.consumemoviesapi.domain.models.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MovieService {

    @GET("/movies/all")
    suspend fun getAllMovies(): List<Movie>

}