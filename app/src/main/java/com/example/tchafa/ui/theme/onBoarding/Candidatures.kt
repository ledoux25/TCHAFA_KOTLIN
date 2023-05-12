package com.example.tchafa.ui.theme.onBoarding

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tchafa.ui.theme.TCHAFATheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tchafa.R
import com.example.tchafa.ui.theme.textcolor


data class CardItem(val title: String, val description: String)

@Composable
fun Candidature(cardItems: List<CardItem>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(cardItems) { cardItem ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = 8.dp
            ) {
                Column(modifier = Modifier.padding(50.dp)) {
                    Text(text = cardItem.title)
                    Text(text = cardItem.description)
                }
            }
        }
    }
}

@Composable
fun TwoInterfaces() {
    Surface(color = MaterialTheme.colors.background) {
        Row {
            // Interface avec background
            Surface(
                modifier = Modifier
                    .background(Color.LightGray)
                    .weight(1f),
                content = {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        content = {
                            Text("Interface avec background")
                            Text("Cette interface a un arrière-plan gris clair.")
                        }
                    )
                }
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Interface sans background
            Surface(
                modifier = Modifier.weight(1f),
                content = {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        content = {
                            Text("Interface sans background")
                            Text("Cette interface n'a pas d'arrière-plan.")
                        }
                    )
                }
            )
        }
    }
}

@Composable
fun candidatures(){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center)
    {

    }
}



@Composable
fun myTopAppBar()
{
    TopAppBar(modifier = Modifier.fillMaxWidth()) {
        Image(painter = painterResource(R.drawable.leftline), contentDescription = "", )
        Text(text = "Toko")
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun CandidaturePreview() {
    val cardItems = listOf(
        CardItem("Card Title 1", "Description of Card 1"),
        CardItem("Card Title 2", "Description of Card 2"),
        CardItem("Card Title 3", "Description of Card 3")
    )

    TCHAFATheme {
      Scaffold(
          topBar = { myTopAppBar() },
          content = { Candidature(cardItems) },

      )
    }
}

@Composable
fun content()
{
    // Ici tu met la fonction de la fonction aui va gerer
    //Candidature(cardItems)
}