package com.example.tchafa.need

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
import com.example.tchafa.R
import com.example.tchafa.navigation.Screen
import com.example.tchafa.components.bottomBorder
import com.example.tchafa.components.rememberImeState
import com.example.tchafa.data.Need
import com.example.tchafa.data.User
import com.example.tchafa.start.Email
import com.example.tchafa.ui.theme.*
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore


@Composable
@SuppressLint("UnrememberedMutableState")
fun NeedDetailViews( navController: NavController) {
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val Salary = remember { mutableStateOf("") }
    val Localisation = remember { mutableStateOf("") }
    val Sector = remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
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
                .background(LightGreen)
                .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                Modifier
                    .fillMaxWidth()
                    .height((screenHeight / 6))
                    .background(Background),
                horizontalAlignment = Alignment.Start
            ){
                Button(
                    onClick = { navController.popBackStack()},
                    modifier = Modifier.height(50.dp).width(70.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    elevation = null,
                ) {
                    Image(painter = painterResource(R.drawable.back_arrow), contentDescription = "back", modifier = Modifier
                        .padding(start = 7.dp)
                        .size(50.dp))
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Text(text = "Need detail", fontSize = 42.sp, fontWeight = FontWeight.Medium, color = White)
                }
            }

            Column(
                Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .height((screenHeight / 2))
                    .background(White)
                    .padding(vertical = 15.dp, horizontal = 25.dp),
                verticalArrangement = Arrangement.SpaceAround

            ) {

                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .border(
                                BorderStroke(
                                    width = 2.dp,
                                    color = LightBlack
                                ),
                                shape = RoundedCornerShape(15)
                            ),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            textColor = Color.Black
                        ),
                        placeholder = { Text(text = "Enter Localisation",color = LightBlack, fontSize = 20.sp) },
                        value = Localisation.value,
                        onValueChange = {
                            Localisation.value = it
                        })

                    Spacer(modifier = Modifier.height(20.dp))

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .border(
                                BorderStroke(
                                    width = 2.dp,
                                    color = LightBlack
                                ),
                                shape = RoundedCornerShape(15)
                            ),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            textColor = Color.Black
                        ),
                        placeholder = { Text(text = "Enter Sector",color = LightBlack, fontSize = 20.sp) },
                        value = Sector.value,
                        onValueChange = {
                            Sector.value = it
                        })

                    Spacer(modifier = Modifier.height(20.dp))

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                            .border(
                                BorderStroke(
                                    width = 2.dp,
                                    color = LightBlack
                                ),

                                shape = RoundedCornerShape(15)
                            ),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            textColor = Color.Black
                        ),
                        placeholder = { Text(text = "Enter Description",color = LightBlack, fontSize = 20.sp) },
                        value = Salary.value,
                        onValueChange = {
                           Salary.value = it
                        })
                }
            }
            Button(
                onClick = {
                    if (TextUtils.isEmpty(Localisation.value.toString())) {
                        Toast.makeText(context, "Please enter job Description", Toast.LENGTH_SHORT).show()
                    } else if (TextUtils.isEmpty(Salary.value.toString())) {
                        Toast.makeText(context, "Please enter job Localisation", Toast.LENGTH_SHORT)
                            .show()
                    } else if (TextUtils.isEmpty(Salary.value.toString())) {
                        Toast.makeText(context, "Please enter job sector", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        addDataToFirebase(
                            Salary.value,
                            Localisation.value,
                            Sector.value, context
                        )
                        navController.popBackStack()
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
}

fun addDataToFirebase(
    Description: String,
    Localisation: String,
    Sector: String,
    context: Context
) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val dbNeed: CollectionReference = db.collection("Users").document("$Email").collection("Needs")
    val needs = Need(Description, Localisation, Sector)

    dbNeed.add(needs).addOnSuccessListener {
        Toast.makeText(
            context,
            "Your Need has been saved sucessfully",
            Toast.LENGTH_SHORT
        ).show()

    }.addOnFailureListener { e ->
        Toast.makeText(context, "Fail to add need \n$e", Toast.LENGTH_SHORT).show()
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    Surface(color = Color.White) {
    }
}

