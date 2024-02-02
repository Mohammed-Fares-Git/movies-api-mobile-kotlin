package com.mohammedfares.consumemoviesapi.domain.use_cases

import com.mohammedfares.consumemoviesapi.comon.AuthManager
import com.mohammedfares.consumemoviesapi.comon.Resourse
import com.mohammedfares.consumemoviesapi.data.remote.AuthService
import com.mohammedfares.consumemoviesapi.domain.models.AuthRequest
import com.mohammedfares.consumemoviesapi.domain.models.AuthResponse
import com.mohammedfares.consumemoviesapi.domain.models.RegisterRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    val api: AuthService,
    val authManager: AuthManager
) {
    operator fun invoke(registerRequest: RegisterRequest): Flow<Resourse<AuthResponse>> = flow {
        emit( Resourse.Loading())
        try {
            val authResponse = api.registerUser(registerRequest)
            authManager.login(authResponse)
            emit(Resourse.Success(authResponse))
        } catch (e: Exception) {
            emit(Resourse.Error(e.message.toString()))
        }
    }.catch {
        emit(Resourse.Error(it.message.toString()))
    }
}