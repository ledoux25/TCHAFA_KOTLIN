package com.example.tchafa

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.Publication.Add_Publication
import com.example.tchafa.ui.theme.LightGreen
import com.example.tchafa.ui.theme.SecularOne


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            NeedDetail()

        }
    }
}

/*@Composable
fun TwoBoxesWithContentAndButtons() {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Box(modifier = Modifier.size(50.dp)) {
                    // Composants de la première petite box
                }
                Box(modifier = Modifier.size(50.dp)) {
                    // Composants de la deuxième petite box
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                // Contenu de la boîte principale
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Box(modifier = Modifier.size(50.dp)) {
                    // Composants de la première petite box
                }
                Box(modifier = Modifier.size(50.dp)) {
                    // Composants de la deuxième petite box
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                // Contenu de la boîte principale
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { /* Action du premier bouton */ }) {
                Text("Bouton 1")
            }

            Button(onClick = { /* Action du deuxième bouton */ }) {
                Text("Bouton 2")
            }

            Button(onClick = { /* Action du troisième bouton */ }) {
                Text("Bouton 3")
            }
        }
    }
}*/



