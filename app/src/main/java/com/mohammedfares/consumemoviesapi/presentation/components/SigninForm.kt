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
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohammedfares.consumemoviesapi.domain.models.RegisterRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SigninForm(registerAction: (RegisterRequest)->Unit) {

    var userName by remember {
        mutableStateOf("")
    }

    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var image by remember {
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
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text(text = "Username") })

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text(text = "Username") })

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = image,
            onValueChange = { image = it },
            label = { Text(text = "Username") })

        Spacer(modifier = Modifier.height(25.dp))


        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text(text = "Username") })

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedButton(onClick = { registerAction( RegisterRequest(firstName,lastName,userName,password,image) ) }, content = { Text(text = "LogIn")})
    }
}


