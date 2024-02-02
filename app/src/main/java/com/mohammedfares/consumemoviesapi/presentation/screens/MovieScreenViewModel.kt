package com.mohammedfares.consumemoviesapi.presentation.screens

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.$
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class MovieScreenViewModel: ViewModel(){


    val _Screen: MutableStateFlow<MovieScreenPage> = MutableStateFlow<MovieScreenPage>(MovieScreenPage.List)
    val screen = _Screen as StateFlow<MovieScreenPage>


    fun navigateToAdd(screen: MovieScreenPage) {
        _Screen.value = screen
    }
}
