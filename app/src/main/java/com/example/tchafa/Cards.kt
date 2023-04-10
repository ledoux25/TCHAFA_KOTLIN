package com.example.tchafa

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyUI() {

            Surface(

                modifier = Modifier.fillMaxSize(),
                color = Color.LightGray

            ){
                Column(modifier = Modifier.padding(16.dp)
                ) {

                    TopImage()
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxWidth()


                    ) {
                        Card(
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .fillMaxWidth(),
                            elevation = 8.dp
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Box(

                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.White),
                                    contentAlignment = Alignment.Center)
                                {
                                    var textfieldstate by remember{ mutableStateOf("") }

                                    TextField(value = textfieldstate,
                                        onValueChange ={textfieldstate= it},
                                        label = { Text(text = "Localisation")},
                                        leadingIcon = {
                                            Image(
                                                painter = painterResource(id = R.drawable.img_1),
                                                contentDescription = "My Image",
                                                modifier = Modifier
                                                    .size(34.dp)
                                                    .padding(8.dp)
                                            )
                                        },
                                        colors = TextFieldDefaults.textFieldColors(
                                            unfocusedLabelColor = Color.Blue,
                                            focusedLabelColor = Color.Blue,
                                            backgroundColor = Color.Transparent,
                                            leadingIconColor = Color.Blue.copy(
                                                TextFieldDefaults.IconOpacity
                                            ),
                                            focusedIndicatorColor = Color.Blue,
                                            unfocusedIndicatorColor = Color.Blue.copy(
                                                TextFieldDefaults.UnfocusedIndicatorLineOpacity
                                            ),
                                            cursorColor = Color.Blue,
                                            textColor = Color.Blue
                                        ))
                                }

                                Box(

                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.White),
                                    contentAlignment = Alignment.Center)
                                {
                                    var textfieldstate by remember{ mutableStateOf("")}

                                    TextField(value = textfieldstate,
                                        onValueChange ={textfieldstate= it},
                                        label = { Text(text = "25 ans")},
                                        leadingIcon = {
                                            Image(
                                                painter = painterResource(id = R.drawable.img_2),
                                                contentDescription = "My Image",
                                                modifier = Modifier
                                                    .size(34.dp)
                                                    .padding(8.dp)
                                            )
                                        },
                                        colors = TextFieldDefaults.textFieldColors(
                                            unfocusedLabelColor = Color.Blue,
                                            focusedLabelColor = Color.Blue,
                                            backgroundColor = Color.Transparent,
                                            leadingIconColor = Color.Blue.copy(
                                                TextFieldDefaults.IconOpacity
                                            ),
                                            focusedIndicatorColor = Color.Blue,
                                            unfocusedIndicatorColor = Color.Blue.copy(
                                                TextFieldDefaults.UnfocusedIndicatorLineOpacity
                                            ),
                                            cursorColor = Color.Blue,
                                            textColor = Color.Blue
                                        ))
                                }
                                Box(

                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.White),
                                    contentAlignment = Alignment.Center)
                                {
                                    var textfieldstate by remember{ mutableStateOf("")}

                                    TextField(value = textfieldstate,
                                        onValueChange ={textfieldstate= it},
                                        label = { Text(text = "2/5")},
                                        leadingIcon = {
                                            Image(
                                                painter = painterResource(id = R.drawable.img_3),
                                                contentDescription = "My Image",
                                                modifier = Modifier
                                                    .size(34.dp)
                                                    .padding(8.dp)
                                            )
                                        },
                                        colors = TextFieldDefaults.textFieldColors(
                                            unfocusedLabelColor = Color.Blue,
                                            focusedLabelColor = Color.Blue,
                                            backgroundColor = Color.Transparent,
                                            leadingIconColor = Color.Blue.copy(
                                                TextFieldDefaults.IconOpacity
                                            ),
                                            focusedIndicatorColor = Color.Blue,
                                            unfocusedIndicatorColor = Color.Blue.copy(
                                                TextFieldDefaults.UnfocusedIndicatorLineOpacity
                                            ),
                                            cursorColor = Color.Blue,
                                            textColor = Color.Blue
                                        ))
                                }
                            }
                        }
                    }


                    Card(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                        elevation = 8.dp
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(16.dp)
                                .align(Alignment.End)

                        ) {
                            Text(
                                text = "Skills",
                                style = MaterialTheme.typography.h6
                            )
                            Button(
                                onClick = { /* Add button click handler */ },
                                modifier = Modifier
                                    .padding(top = 8.dp)
                                    .width(200.dp)

                            ) {
                                Text(text = "ADD")
                            }
                        }
                    }
                }
            }

    }

@Composable
fun TopImage() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "My Image",
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .padding(top = 16.dp)
        )
        Text(
            text = "Kanteu Ananga Maxime",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun maxime(){

    MyUI()
}