package com.example.tchafa.need

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ContentAlpha.medium
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.ui.theme.Shapes


@Composable
fun NeedDetailViews(){

    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }
    var input3 by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxSize()
            //.fillMaxHeight()
            .padding(16.dp),
    ) {
        Text("Need Detail")
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            //.fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(
            text = "Need Detail",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )

        OutlinedTextField(
            value = input1,
            onValueChange = {
                input1 = it
            },
            label = { Text ("Payer par") },

            modifier = Modifier
                .fillMaxWidth()

        )

        OutlinedTextField(
            value = input2,
            onValueChange = {
                input2 = it
            },
            label = { Text ("Lieu de service") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = input3,
            onValueChange = {
                input3 = it
            },
            label = { Text ("Secteur demandé") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = { /*TODO*/ },
            shape = Shapes.medium,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .border(8.dp, Color.Green),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                backgroundColor = Color.Green
            )
        ) {
            Text(text = "Publier")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    Surface(color = Color.White) {
        NeedDetailViews()
    }
}