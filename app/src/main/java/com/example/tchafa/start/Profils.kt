package com.example.tchafa.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.tchafa.R
import com.example.tchafa.ui.theme.TCHAFATheme


@Composable
fun UserProfileScreen(user: User) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Profil de ${user.name}") }
            )
        },
        content = {it
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = rememberImagePainter(data = user.photoUrl),
                    contentDescription = user.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(2.2f)
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    elevation = 15.dp
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = user.jobTitle, style = MaterialTheme.typography.h5)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = user.location)
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    elevation = 8.dp
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Salaire", style = MaterialTheme.typography.h6)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = user.salary)
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    elevation = 8.dp
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Période de travail", style = MaterialTheme.typography.h6)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = user.workPeriod)
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    elevation = 8.dp
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Description", style = MaterialTheme.typography.h6)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = user.description)
                    }
                }
                Button(
                    onClick = { /* handle button click */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Contacter ${user.name}")
                }
            }
        }
    )
}

data class User(
    val name: String,
    val photoUrl: Painter,
    val jobTitle: String,
    val location: String,
    val salary: String,
    val workPeriod: String,
    val description: String
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TCHAFATheme {
        UserProfileScreen(
            user = User(
                name = "Malonju laure",
                photoUrl = painterResource(R.drawable.mouf),
                jobTitle = "Menagere",
                location = "cameroun, douala",
                salary = "100 000 frcf",
                workPeriod = "Temps plein",
                description = "J'aime faire le menage fier de ce que de faire du menage la cuisine garde les enfant."
            )
        )
    }
}
