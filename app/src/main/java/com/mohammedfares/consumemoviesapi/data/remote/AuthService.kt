package com.mohammedfares.consumemoviesapi.data.remote

import com.mohammedfares.consumemoviesapi.domain.models.AuthRequest
import com.mohammedfares.consumemoviesapi.domain.models.AuthResponse
import com.mohammedfares.consumemoviesapi.domain.models.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest): AuthResponse

    @POST("/auth/authenticate")
    suspend fun authenticateUser(@Body authRequest: AuthRequest): AuthResponse
}