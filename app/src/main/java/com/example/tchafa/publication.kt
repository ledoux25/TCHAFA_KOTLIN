package com.example.tchafa

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }

    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Rechercher...",
                    color = Color.Gray
                )
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

enum class ColorFilter(val color: Color) {
    RED(Color.Red),
    BLUE(Color.Blue),
    GREEN(Color.Green)
}

@Composable
fun FilterColors(onColorChanged: (Color) -> Unit) {
    val selectedColor = remember { mutableStateOf(ColorFilter.RED) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ColorFilter.values().forEach { colorFilter ->
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(colorFilter.color)
                    .clickable { selectedColor.value = colorFilter }
            ) {
                if (selectedColor.value == colorFilter) {
                    Text(
                        text = "✓",
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }

    onColorChanged(selectedColor.value.color)
}

@Composable
fun ProfileCard(
    name: String,
    firstName: String,
    profileImageUrl: String,
    onButton1Click: () -> Unit,
    onButton2Click: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxWidth().height(200.dp),
    ) {
        Image(
            painter = rememberImagePainter(profileImageUrl),
            contentDescription = "Photo de profil",
            modifier = Modifier.size(100.dp).clip(shape = CircleShape)
                .align(alignment = Alignment.TopStart)
        )
        Column(modifier = Modifier.align(alignment = Alignment.TopCenter)) {
            Text(text = name, fontWeight = FontWeight.Bold)
            Text(text = firstName)
        }
        Row(
            modifier = Modifier.align(alignment = Alignment.BottomCenter)
                .padding(vertical = 16.dp)
        ) {
            Button(onClick = onButton1Click) {
                Text(text = "Bouton 1")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = onButton2Click) {
                Text(text = "Bouton 2")
            }
        }
    }
}
