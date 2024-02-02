package com.mohammedfares.consumemoviesapi.comon

sealed class Auth{
    class Authenticated(val userName: String, val firstName: String, val lastName: String, val image: String, val token: String): Auth()
    object UnAuthenticated: Auth()
}
