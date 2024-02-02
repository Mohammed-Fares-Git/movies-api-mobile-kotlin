package com.mohammedfares.consumemoviesapi.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.StarOutline
import androidx.compose.material.icons.sharp.StarRate
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RatingBar(stars: Int) {
    LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
        items(stars) {
            Icon(imageVector = Icons.Sharp.StarRate, contentDescription = null, tint = Color.Yellow, modifier = Modifier.padding(1.dp))
        }
    }
}


@Preview
@Composable
fun RatingBarPreview() {
    Column {
        RatingBar(0)
        RatingBar(3)
        RatingBar(1)
        RatingBar(5)
    }
}