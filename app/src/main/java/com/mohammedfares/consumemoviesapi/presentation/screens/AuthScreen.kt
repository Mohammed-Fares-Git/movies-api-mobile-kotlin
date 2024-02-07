package com.mohammedfares.consumemoviesapi.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohammedfares.consumemoviesapi.comon.Resourse
import com.mohammedfares.consumemoviesapi.presentation.components.LoginForm
import com.mohammedfares.consumemoviesapi.presentation.components.SigninForm
import org.w3c.dom.Text

@Composable
fun AuthScreen(viewModel: AuthScreenViewModel) {

    val action = viewModel.authScreenAction.collectAsState()
    val registration = viewModel.registerStateFlow.collectAsState()


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {
        when(action.value) {
            AuthScreenActions.LogIn -> LoginForm(viewModel) {
                viewModel.authUser(it)
                Log.d("looking", it.toString())
            }
            AuthScreenActions.SignIn -> SigninForm {
                viewModel.registerUser(it)
            }
        }

        /*
        when(registration.value){
            is Resourse.Empty -> Text(text = "Empty", color = Color.Blue)
            is Resourse.Error -> Text(text = "Error", color = Color.Red)
            is Resourse.Loading -> Text(text = "Loading", color = Color.Yellow)
            is Resourse.Success -> Text(text = "success", color = Color.Green)
        }

         */


    }


}