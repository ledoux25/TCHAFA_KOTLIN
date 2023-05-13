package com.example.tchafa.profile


import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.navigation.Screen
import com.example.tchafa.components.bottomBorder
import com.example.tchafa.components.rememberImeState
import com.example.tchafa.data.Need
import com.example.tchafa.data.User
import com.example.tchafa.navigation.NavigationItems
import com.example.tchafa.start.Email
import com.example.tchafa.ui.theme.*
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore


@Composable
@SuppressLint("UnrememberedMutableState")
fun ProfileForm( navController: NavController) {
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val Nom = remember { mutableStateOf("") }
    val Prenom = remember { mutableStateOf("") }
    val Anniv = remember { mutableStateOf("") }
    val ville = remember { mutableStateOf("") }
    val langue = remember { mutableStateOf("") }



        Column(
            Modifier
                .background(BackgroundGray)
                .fillMaxSize()
                .padding(bottom = 20.dp)
                .verticalScroll(scrollState),
             verticalArrangement = Arrangement.SpaceBetween,
             horizontalAlignment = Alignment.CenterHorizontally)
        {
            LaunchedEffect(key1 = imeState.value) {
                if (imeState.value) {
                    scrollState.scrollTo(scrollState.maxValue)
                }
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .height((screenHeight / 6))
                    .background(Background),
                horizontalAlignment = Alignment.Start
            ){
                    Image(painter = painterResource(R.drawable.back_arrow), contentDescription = "back", modifier = Modifier
                        .padding(start = 7.dp)
                        .clickable { navController.popBackStack() }
                        .size(50.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Text(text = "Fill the form", fontSize = 42.sp, fontWeight = FontWeight.Medium, color = White)
                }
            }

            Column(
                Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .width(screenWidth - 10.dp)
                    .height((screenHeight / 1.5f))
                    .background(White)
                    .padding(vertical = 15.dp, horizontal = 25.dp),
                verticalArrangement = Arrangement.SpaceBetween

            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 15.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Name",
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    TextField(
                        value = Nom.value,
                        onValueChange = {
                            Nom.value = it
                        },
                        modifier = Modifier
                            .bottomBorder(1.dp, LightBlack)
                            .height(50.dp),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Monospace
                        ),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = ComponentBlue,
                            unfocusedBorderColor = LightBlack
                        )
                    )
                }
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 15.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Surname",
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    TextField(
                        value = Prenom.value,
                        onValueChange = {
                            Prenom.value = it
                        },
                        modifier = Modifier
                            .bottomBorder(1.dp, LightBlack)
                            .height(50.dp),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Monospace
                        ),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = ComponentBlue,
                            unfocusedBorderColor = LightBlack
                        )
                    )
                }
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 15.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                )
                {
                    Text(
                        text = "Sector",
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    TextField(
                        value = Anniv.value,
                        onValueChange = {
                            Anniv.value = it
                        },
                        modifier = Modifier
                            .bottomBorder(1.dp, LightBlack)
                            .height(55.dp),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Monospace
                        ),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = ComponentBlue,
                            unfocusedBorderColor = LightBlack
                        )
                    )
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Town",
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        TextField(
                            value = ville.value,
                            onValueChange = {
                                ville.value = it
                            },
                            modifier = Modifier
                                .bottomBorder(1.dp, LightBlack)
                                .height(55.dp),
                            textStyle = TextStyle(
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = ComponentBlue,
                                unfocusedBorderColor = LightBlack
                            )
                        )
                    }
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Language",
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        TextField(
                            value = langue.value,
                            onValueChange = {
                                langue.value = it
                            },
                            modifier = Modifier
                                .bottomBorder(1.dp, LightBlack)
                                .height(55.dp),
                            textStyle = TextStyle(
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = ComponentBlue,
                                unfocusedBorderColor = LightBlack
                            )
                        )
                    }
                }


            }

            Button(
                onClick = {
                    if (TextUtils.isEmpty(Nom.value.toString())) {
                        Toast.makeText(context, "Please enter your name", Toast.LENGTH_SHORT).show()
                    } else if (TextUtils.isEmpty(Prenom.value.toString())) {
                        Toast.makeText(context, "Please enter your surname", Toast.LENGTH_SHORT)
                            .show()
                    } else if (TextUtils.isEmpty(Anniv.value.toString())) {
                        Toast.makeText(context, "Please enter your bithday", Toast.LENGTH_SHORT)
                            .show()
                    } else if (TextUtils.isEmpty(ville.value.toString())) {
                        Toast.makeText(context, "Please enter your town", Toast.LENGTH_SHORT)
                            .show()
                    } else if (TextUtils.isEmpty(langue.value.toString())) {
                        Toast.makeText(context, "Please enter your language", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        addDataToFirebase(
                            Nom.value,
                            Prenom.value,
                            Anniv.value,
                            ville.value,
                            langue.value,context
                        )
                        navController.navigate(route = NavigationItems.Profile.route)
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue),
                shape = RoundedCornerShape(35),
                modifier = Modifier.width(125.dp)
            ) {
                Text(text = "Add", color = Color.Black)
            }
        }
    }


fun addDataToFirebase(
    Nom: String,
    Prenom: String,
    Anniv: String,
    Ville: String,
    Langue: String,

    context: Context
) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val dbUser: DocumentReference = db.collection("Users").document("$Email")
    val user = User(Nom, Prenom, Anniv, Ville, Langue)

    dbUser.set(user).addOnSuccessListener {
        Toast.makeText(
            context,
            "Your infos have been saved sucessfully",
            Toast.LENGTH_SHORT
        ).show()

    }.addOnFailureListener { e ->
        Toast.makeText(context, "Failed to save your infos \n$e", Toast.LENGTH_SHORT).show()
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    Surface(color = Color.White) {
    }
}

