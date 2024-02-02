package com.mohammedfares.consumemoviesapi.comon

sealed class Screen {
    object Auth: Screen()
    object Movies: Screen()
    object Details: Screen()
}
