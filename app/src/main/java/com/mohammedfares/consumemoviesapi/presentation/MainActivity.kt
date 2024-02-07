package com.mohammedfares.consumemoviesapi.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mohammedfares.consumemoviesapi.comon.Auth
import com.mohammedfares.consumemoviesapi.presentation.screens.AuthScreen
import com.mohammedfares.consumemoviesapi.presentation.screens.AuthScreenViewModel
import com.mohammedfares.consumemoviesapi.presentation.screens.MovieScreen
import com.mohammedfares.consumemoviesapi.presentation.ui.theme.ConsumeMoviesApiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    val mainViewModel: MainViewModel by viewModels()
    val authScreenViewModel: AuthScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConsumeMoviesApiTheme {
                val auth = mainViewModel.authState.collectAsState()

                when (auth.value){
                    is Auth.Authenticated -> {
                        Text(text = "main screen", fontSize = 40.sp, fontWeight = FontWeight.Bold)}
                    Auth.UnAuthenticated -> AuthScreen(viewModel = authScreenViewModel)
                }

            }
        }
    }
}
