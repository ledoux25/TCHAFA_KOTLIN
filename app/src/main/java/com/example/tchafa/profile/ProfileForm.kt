package com.example.tchafa.profile


import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.Language
import com.example.tchafa.R
import com.example.tchafa.components.bottomBorder
import com.example.tchafa.components.rememberImeState
import com.example.tchafa.data.User
import com.example.tchafa.navigation.Screen
import com.example.tchafa.publication.birthday
import com.example.tchafa.start.Email
import com.example.tchafa.ui.theme.*
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

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .verticalScroll(scrollState)
    ) {
        LaunchedEffect(key1 = imeState.value) {
            if (imeState.value) {
                scrollState.scrollTo(scrollState.maxValue)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(bottom = 30.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(
                    onClick = { navController.popBackStack()},
                    modifier = Modifier
                        .height(50.dp)
                        .width(70.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    elevation = null,
                ) {
                    Image(painter = painterResource(R.drawable.back_arrow), contentDescription = "back", modifier = Modifier
                        .size(55.dp)
                        .offset(x = -17.dp))
                }
            }
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = "Create Your Proffessional Profile",
                    modifier = Modifier
                        .padding(bottom = 3.dp, start = 20.dp),
                    color = primaryBlue,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "In less than a minute and",
                    modifier = Modifier
                        .padding(start = 20.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Be aknowished",
                    modifier = Modifier
                        .padding(bottom = 3.dp, start = 20.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "fill all the blank spaces!!", color = TextBlack)
            }

            Column(
                Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .height((screenHeight / 2.4f))
                    .background(White)
                    .padding(vertical = 5.dp, horizontal = 25.dp),
                verticalArrangement = Arrangement.SpaceAround

            ) {

                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                )
                {
                    Row {
                        Column(Modifier.width(screenWidth/2)) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                            ){Text(text = "Name", color = Color.Black)}
                            OutlinedTextField(
                                value = Nom.value,
                                onValueChange = { Nom.value = it },
                                singleLine = true,
                                modifier = Modifier
                                    .width(screenWidth / 2.6f)
                                    .height(49.dp),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = LightBlack,
                                    unfocusedBorderColor = LightBlack,
                                    textColor = Color.Black
                                )
                            )
                        }
                        Column(Modifier.width(screenWidth/2)) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                            ){Text(text = "Surname", color = Color.Black)}
                            OutlinedTextField(
                                value = Prenom.value,
                                onValueChange = { Prenom.value = it },
                                singleLine = true,
                                modifier = Modifier
                                    .width(screenWidth / 2.6f)
                                    .height(49.dp),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = LightBlack,
                                    unfocusedBorderColor = LightBlack,
                                    textColor = Color.Black
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                        ,
                    ){
                        Text(text = "Birthday ", color = Color.Black)
                        Text(text = " (00-00-00)", color = TextBlack, fontSize = 14.sp)
                    }
                    OutlinedTextField(
                        value = Anniv.value,
                        onValueChange = { Anniv.value = it },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(49.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = LightBlack,
                            unfocusedBorderColor = LightBlack,
                            textColor = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        Modifier
                            .fillMaxWidth()){Text(text = "Ville", color = Color.Black)}
                    OutlinedTextField(
                        value = ville.value,
                        onValueChange = { ville.value = it },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(49.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = LightBlack,
                            unfocusedBorderColor = LightBlack,
                            textColor = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "Language ", color = Color.Black)
                        Text(text = " (french - english -bilingual)", color = TextBlack, fontSize = 14.sp)
                    }
                    OutlinedTextField(
                        value = langue.value,
                        onValueChange = { langue.value = it },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(49.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = LightBlack,
                            unfocusedBorderColor = LightBlack,
                            textColor = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(start = 20.dp, end = 20.dp, bottom = 70.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
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
                            Toast.makeText(
                                context,
                                "Please enter your language",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }/*else if(TextUtils.equals(langue.value.toString(),"french") || langue.value.toString() != "French" || langue.value.toString() != "English" || langue.value.toString() != "english" || langue.value.toString() != "Bilingual" || langue.value.toString() != "bilingual"){
                            Toast.makeText(context, "Enter a valid language", Toast.LENGTH_SHORT).show()
                        }*/ else {
                            addDataToFirebase(
                                Nom.value,
                                Prenom.value,
                                Anniv.value,
                                ville.value,
                                langue.value,context
                            )
                            navController.navigate(route = Screen.ProfileScreen.route)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue),
                    shape = RoundedCornerShape(35),
                    modifier = Modifier.width(125.dp)
                ) {
                    Text(text = "Add", color = Color.White)
                }
            }
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
    val user = User(Nom, Prenom, Anniv, Langue, Ville)

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

