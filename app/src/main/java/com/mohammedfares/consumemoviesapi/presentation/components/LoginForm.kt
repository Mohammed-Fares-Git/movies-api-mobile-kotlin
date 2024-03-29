package com.mohammedfares.consumemoviesapi.presentation.components

import android.widget.HorizontalScrollView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohammedfares.consumemoviesapi.comon.Resourse
import com.mohammedfares.consumemoviesapi.domain.models.AuthRequest
import com.mohammedfares.consumemoviesapi.presentation.screens.AuthScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm( viewModel: AuthScreenViewModel, loginAction: (authRequest: AuthRequest)->Unit) {

    val authentication = viewModel.loginStateFlow.collectAsState()

    var userName by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text(text = "Username") })

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Username") })

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedButton(onClick = { viewModel.authUser(AuthRequest(userName,password)) }, content = { Text(text = "LogIn")})

        when(authentication.value){
            is Resourse.Empty -> Text(text = "Empty", color = Color.Blue, fontSize = 30.sp)
            is Resourse.Error -> {

                Text(text = authentication.value.message.toString(), color = Color.Red, fontSize = 30.sp)
            }
            is Resourse.Loading -> Text(text = "Loading", color = Color.Yellow, fontSize = 30.sp)
            is Resourse.Success -> {
                Text(text = authentication.value.data.toString(), color = Color.Green, fontSize = 30.sp)
            }
        }
    }
}