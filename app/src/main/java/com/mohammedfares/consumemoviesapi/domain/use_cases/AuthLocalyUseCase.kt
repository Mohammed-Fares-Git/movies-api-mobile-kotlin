package com.mohammedfares.consumemoviesapi.domain.use_cases

import com.mohammedfares.consumemoviesapi.comon.Auth
import com.mohammedfares.consumemoviesapi.comon.AuthManager
import com.mohammedfares.consumemoviesapi.comon.Resourse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthLocalyUseCase @Inject constructor(
    val authManager: AuthManager
) {
    operator fun invoke(): Flow<Auth> = flow {
        try {
            val isUserAuthenticated = authManager.isUserAuthenticated()
            if (isUserAuthenticated){
                emit(Auth.Authenticated(
                    authManager.username!!,
                    authManager.firstName!!,
                    authManager.lastName!!,
                    authManager.image!!,
                    authManager.token!!
                ))
            }
            else {
                emit(Auth.UnAuthenticated)
            }
        } catch (e: Exception) {
            emit(Auth.UnAuthenticated)
        }
    }.catch {
        emit(Auth.UnAuthenticated)
    }
}