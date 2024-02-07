package com.mohammedfares.consumemoviesapi.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammedfares.consumemoviesapi.comon.Resourse
import com.mohammedfares.consumemoviesapi.domain.models.AuthRequest
import com.mohammedfares.consumemoviesapi.domain.models.AuthResponse
import com.mohammedfares.consumemoviesapi.domain.models.RegisterRequest
import com.mohammedfares.consumemoviesapi.domain.use_cases.AuthLocalyUseCase
import com.mohammedfares.consumemoviesapi.domain.use_cases.AuthUseCase
import com.mohammedfares.consumemoviesapi.domain.use_cases.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class AuthScreenViewModel @Inject constructor(
    val registerUserUseCase: RegisterUserUseCase,
    val authUserUseCase: AuthUseCase,
    val authLocalyUseCase: AuthLocalyUseCase

): ViewModel() {

    private val _AuthScreenAction = MutableStateFlow<AuthScreenActions>(AuthScreenActions.LogIn)
    val authScreenAction: StateFlow<AuthScreenActions> = _AuthScreenAction

    private val _RegisterStateFlow = MutableStateFlow<Resourse<AuthResponse>>(Resourse.Empty())
    val registerStateFlow: StateFlow<Resourse<AuthResponse>> = _RegisterStateFlow


    private val _LoginStateFlow = MutableStateFlow<Resourse<AuthResponse>>(Resourse.Empty())
    val loginStateFlow = _LoginStateFlow.asStateFlow()




    fun navigateTo(action: AuthScreenActions){
        _AuthScreenAction.value = action
    }

    fun registerUser(registerRequest: RegisterRequest) = viewModelScope.launch {
        registerUserUseCase(registerRequest).collect {
            _RegisterStateFlow.value = it
        }
    }

    fun authUser(authRequest: AuthRequest) {
        viewModelScope.launch {
            authUserUseCase(authRequest).collect {
                _LoginStateFlow.value = it
            }
        }
    }

}