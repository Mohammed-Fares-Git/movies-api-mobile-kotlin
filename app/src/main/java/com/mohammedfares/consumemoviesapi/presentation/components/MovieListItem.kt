package com.mohammedfares.consumemoviesapi.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mohammedfares.consumemoviesapi.domain.models.Movie
import com.mohammedfares.consumemoviesapi.presentation.ui.theme.ConsumeMoviesApiTheme

@Composable
fun MovieListItem(movie: Movie) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = movie.image,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp), contentAlignment = Alignment.BottomStart) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = movie.name,
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textDecoration = TextDecoration.Underline
                    )
                    
                    Spacer(modifier = Modifier.height(5.dp))
                    
                    RatingBar(stars = movie.stars)
                }
            }
        }
    }

}

