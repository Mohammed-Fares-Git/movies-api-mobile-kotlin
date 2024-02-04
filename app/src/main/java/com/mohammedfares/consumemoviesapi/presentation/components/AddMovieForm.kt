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
import com.mohammedfares.consumemoviesapi.domain.models.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMovieForm(actionAdd: (movie: Movie)-> Unit) {

    var movieName by remember {
        mutableStateOf("")
    }

    var movieDesc by remember {
        mutableStateOf("")
    }

    var movieImage by remember {
        mutableStateOf("")
    }

    var moveiPrice by remember {
        mutableStateOf(0.0)
    }

    var movieYear by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = movieName,
            onValueChange = { movieName = it },
            label = { Text(text = "Username") })

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = movieDesc,
            onValueChange = { movieDesc = it },
            label = { Text(text = "Username") })

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = movieImage,
            onValueChange = { movieImage = it },
            label = { Text(text = "Username") })

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = movieYear,
            onValueChange = { movieYear = it },
            label = { Text(text = "Username") })

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = moveiPrice.toString(),
            onValueChange = { moveiPrice = it.toDouble() },
            label = { Text(text = "Username") })

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedButton(onClick = {
                                 actionAdd( Movie(
                                     null,
                                     movieName,
                                     movieDesc,
                                     moveiPrice,
                                     movieImage,
                                     movieYear,
                                     3
                                 ) )
        }, content = { Text(text = "LogIn")})
    }
}


