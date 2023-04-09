package com.example.tchafa

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MaPage() {
    var searchText by remember { mutableStateOf("") }
    Surface(
        color = Color(0xFF590D22),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Titre de ma page",
                style = MaterialTheme.typography.h4,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text("Rechercher...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color(0x80404040))
                    .alpha(0.9f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    repeat(3) {
                        ProfileBox(
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileBox(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, Color.White)
            .padding(16.dp)
            .clickable { /* TODO: Action on click */ }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter("https://images.unsplash.com/photo-1679499163638-a38b6c079595?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw4OHx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60"),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Nom Prénom",
                style = MaterialTheme.typography.h5,
                color = Color.White
            )
            Text(
                text = "Description ou métier",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { /* TODO: Action on button 1 click */ }) {
                    Text(text = "Profil")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = { /* TODO: Action on button 2 click */ }) {
                    Text(text = "Contact")
                }
            }
        }
    }
}

