package com.mohammedfares.consumemoviesapi.presentation.screens

sealed class MovieScreenPage{
    object Add: MovieScreenPage()
    object List: MovieScreenPage()
}