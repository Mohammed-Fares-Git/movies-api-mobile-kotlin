package com.mohammedfares.consumemoviesapi.comon

import android.content.Context
import android.content.SharedPreferences
import com.mohammedfares.consumemoviesapi.domain.models.AuthResponse

class AuthManager(private val ctx: Context) {

    private val sharedPreferences: SharedPreferences =
        ctx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)


    var isLoggedIn: Boolean
        get() = sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
        set(value) = sharedPreferences.edit().putBoolean(KEY_IS_LOGGED_IN, value).apply()

    var username: String?
        get() = sharedPreferences.getString(KEY_USERNAME, null)
        set(value) = sharedPreferences.edit().putString(KEY_USERNAME, value).apply()

    var token: String?
        get() = sharedPreferences.getString(KEY_TOKEN,"")
        set(value) = sharedPreferences.edit().putString(KEY_TOKEN, value).apply()


    var firstName: String?
        get() = sharedPreferences.getString(KEY_FIRST_NAME, null)
        set(value) = sharedPreferences.edit().putString(KEY_FIRST_NAME, value).apply()

    var lastName: String?
        get() = sharedPreferences.getString(KEY_LAST_NAME, null)
        set(value) = sharedPreferences.edit().putString(KEY_LAST_NAME, value).apply()
    var image: String?
        get() = sharedPreferences.getString(KEY_IMAGE, null)
        set(value) = sharedPreferences.edit().putString(KEY_IMAGE, value).apply()

    fun login(authResponse: AuthResponse) {
        isLoggedIn = true
        this.username = username
        this.firstName = authResponse.firstName
        this.lastName = authResponse.lastName
        this.token = authResponse.jwtToken
        this.image = authResponse.image
    }

    fun logout() {
        isLoggedIn = false
        username = null
        firstName = null
        lastName = null
        token = null
        image = null
    }


    fun isUserAuthenticated(): Boolean {
        return isLoggedIn && !token.isNullOrBlank()
    }

    companion object {
        private const val PREF_NAME = "auth_to_movie_api_service"
        private const val KEY_USERNAME = "username"
        private const val KEY_FIRST_NAME = "firstname"
        private const val KEY_LAST_NAME = "lastname"
        private const val KEY_IS_LOGGED_IN = "isLoggedIn"
        private const val KEY_TOKEN = "token_jwt"
        private const val KEY_IMAGE = "user_image"
        //private const val KEY_ID = "id"
    }

}