package com.mohammedfares.consumemoviesapi.presentation.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.mohammedfares.consumemoviesapi.comon.Auth
import com.mohammedfares.consumemoviesapi.presentation.components.AddMovieForm
import com.mohammedfares.consumemoviesapi.presentation.components.MovieList
import com.mohammedfares.consumemoviesapi.presentation.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(viewModel: MovieScreenViewModel, user: Auth.Authenticated) {
    val screen = viewModel.screen.collectAsState()
    Scaffold (
        topBar = { TopBar(user = user) },
        floatingActionButton = {
            if (screen.value is MovieScreenPage.List) {
                FloatingActionButton(onClick = { viewModel.navigateToAdd(MovieScreenPage.Add) }) {
                    Icon(imageVector = Icons.Sharp.Add, contentDescription = null)
                }
            }
        }
    )
    { padding ->
        when(screen.value) {
            MovieScreenPage.Add -> AddMovieForm {}
            MovieScreenPage.List -> MovieList(movies = emptyList(), paddin = padding)
        }
    }

}