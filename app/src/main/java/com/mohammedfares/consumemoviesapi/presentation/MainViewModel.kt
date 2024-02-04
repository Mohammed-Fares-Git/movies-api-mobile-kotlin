package com.mohammedfares.consumemoviesapi.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammedfares.consumemoviesapi.comon.Auth
import com.mohammedfares.consumemoviesapi.domain.use_cases.AuthLocalyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val auth: AuthLocalyUseCase
): ViewModel() {
    init {
        viewModelScope.launch {
            auth().collect {
                _AuthState.value = it
            }
        }
    }

    private val _AuthState = MutableStateFlow<Auth>(Auth.UnAuthenticated)
    val authState = _AuthState as StateFlow<Auth>

}