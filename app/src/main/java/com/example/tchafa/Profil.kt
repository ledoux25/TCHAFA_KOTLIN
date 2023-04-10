package com.example.tchafa



import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {



    Scaffold(
        bottomBar = { BottomBar() },
        topBar = {
            TopAppBar(
                title = { /* Action pour le bouton de retour */ },
                navigationIcon = {
                    IconButton(onClick = { /* Action pour le bouton de retour */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.hh),
                            contentDescription = "My Image",
                            modifier = Modifier
                                .size(44.dp)
                                .padding(8.dp)
                        )
                    }
                },
                backgroundColor = Color.Red,
                elevation = 0.dp
            )
        }

    ) {

        Surface(

            modifier = Modifier.fillMaxSize(),
            color = Color.Red

        ) {
            Column(
                // modifier = Modifier.padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(70.dp))
                ImageInCircle()

                Box(

                    modifier = Modifier.fillMaxWidth()


                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize()
                            .height(950.dp)
                            .width(550.dp) ,
                        shape = RoundedCornerShape(percent = 10)


                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)

                        ) {

                            Spacer(modifier = Modifier.height(30.dp))

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ){
                                Text(
                                    text = "Kanteu Aananga Maxime",
                                    style = TextStyle(fontSize = 20.sp),

                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Spacer(modifier = Modifier.height(30.dp))
                            Box(

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.White),
                                contentAlignment = Alignment.Center)
                            {
                                var textfieldstate by remember{ mutableStateOf("")}

                                TextField(value = textfieldstate,
                                    onValueChange ={textfieldstate= it},
                                    label = { Text(text = "Plombier")},
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(id = R.drawable.img_10),
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
                                    label = { Text(text = "25 ans ")},
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(id = R.drawable.img_11),
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
                                    label = { Text(text = "Francais,Anglais")},
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(id = R.drawable.img_6),
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
                                    label = { Text(text = "Travailleur,Motivé,3 ans")},
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(id = R.drawable.img_8),
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
                                    label = { Text(text = "Douala_Cameroun")},
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(id = R.drawable.img_5),
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
                                    label = { Text(text = "3/5")},
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(id = R.drawable.img_7),
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
                            Spacer(modifier = Modifier.height(20.dp))
                            Box(
                                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                            ) {
                                Button(
                                    onClick = { /* action à effectuer lors du clic */ },
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Color.Red,
                                        contentColor = Color.White
                                    )
                                ) {
                                    Text("CONFIRM")
                                }

                            }

                        }

                    }
                }


            }
        }
    }


}


@Composable
fun ImageInCircle() {
    val image = painterResource(R.drawable.img)

    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)

        )

    }
}



@Composable
fun BottomBar() {
    BottomNavigation(
        backgroundColor = Color.Gray,
        elevation = 8.dp
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Accueil") }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Default.Settings, contentDescription = "Recherche") },
            label = { Text("Parametre") }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Default.Search, contentDescription = "Recherche") },
            label = { Text("Recherche") }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Default.Person, contentDescription = "Profil") },
            label = { Text("Profil") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun maxi(){

    MainScreen()
}