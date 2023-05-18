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
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

var title :String? = ""
var sector :String? = ""
var localisation :String? = ""
var description :String? = ""


@Composable
@SuppressLint("UnrememberedMutableState")
fun NeedModifyViews( navController: NavController) {
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val Description = remember { mutableStateOf("") }
    val Localisation = remember { mutableStateOf("") }
    val Sector = remember { mutableStateOf("") }
    val Title = remember { mutableStateOf("") }
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val docList = ArrayList<Map<String, Any>>()

    val docRef = db.collection("Users").document("$Email").collection("Needs").document("$titre")

    docRef.get().addOnSuccessListener { documentSnapshot ->
        if (documentSnapshot.exists()) {
            val docData = documentSnapshot.data

             title = docData?.get("title").toString()
             localisation = docData?.get("localisation").toString()
             sector = docData?.get("sector").toString()
             description = docData?.get("description").toString()



            docList.add(docData!!)
        } else {
            // Document does not exist
        }
    }.addOnFailureListener { exception ->
        // Handle exceptions here
    }
        // if we don't get any data or any error
        // we are displaying a toast message
        // that we donot get any data
        .addOnFailureListener {
            Toast.makeText(
                context,
                "Fail to get the data.",
                Toast.LENGTH_SHORT
            ).show()
        }

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
                        .width(70.dp)
                        .padding(start = 15.dp, top = 10.dp),
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
                    text = "Modify Your Need",
                    modifier = Modifier
                        .padding(bottom = 3.dp, start = 20.dp),
                    color = primaryBlue,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Don't Like This One ?",
                    modifier = Modifier
                        .padding(start = 20.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Modify It",
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
                    .height((screenHeight / 2.5f))
                    .background(White)
                    .padding(vertical = 15.dp, horizontal = 25.dp),
                verticalArrangement = Arrangement.SpaceAround

            ) {

                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()){Text(text = "Title", color = Color.Black)}
                    OutlinedTextField(
                        value = Title.value,
                        onValueChange = { Title.value = it },
                        singleLine = true,
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
                    Row {
                        Column(Modifier.width(screenWidth/2)) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                            ){Text(text = "Localisation", color = Color.Black)}
                            OutlinedTextField(
                                value = Localisation.value,
                                onValueChange = { Localisation.value = it },
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
                            ){Text(text = "Sector", color = Color.Black)}
                            OutlinedTextField(
                                value = Sector.value,
                                onValueChange = { Sector.value = it },
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


                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        Modifier
                            .fillMaxWidth()){Text(text = "Description", color = Color.Black)}
                    OutlinedTextField(
                        value = Description.value,
                        onValueChange = { Description.value = it },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(85.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = LightBlack,
                            unfocusedBorderColor = LightBlack,
                            textColor = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
            Column(Modifier.fillMaxHeight().padding(start = 20.dp, end = 20.dp, bottom = 70.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = {
                        if (TextUtils.isEmpty(Title.value.toString())) {
                            Toast.makeText(context, "Please enter job Title", Toast.LENGTH_SHORT).show()
                        } else if (TextUtils.isEmpty(Localisation.value.toString())) {
                            Toast.makeText(context, "Please enter job Localisation", Toast.LENGTH_SHORT)
                                .show()
                        } else if (TextUtils.isEmpty(Sector.value.toString())) {
                            Toast.makeText(context, "Please enter job sector", Toast.LENGTH_SHORT)
                                .show()
                        } else if (TextUtils.isEmpty(Description.value.toString())) {
                            Toast.makeText(context, "Please enter job Description", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            addDataToFirebase(
                                Description.value,
                                Localisation.value,
                                Sector.value,
                                Title.value,context
                            )
                            navController.popBackStack()
                        }

                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue),
                    shape = RoundedCornerShape(10),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Modify", color = White, fontWeight = FontWeight.Bold, fontSize = 19.sp)
                }
            }
        }
    }
}


private fun updateDataToFirebase(
    Title: String,
    localisation: String,
    secteur: String,
    description: String,
    context: Context
) {
    val updatedCourse = Need(Title, description, localisation, secteur)
    val db = FirebaseFirestore.getInstance();
    db.collection("Users").document("$Email").collection("Needs").document("$titre")
        .set(updatedCourse)
        .addOnSuccessListener {
            Toast.makeText(context, "Need Updated successfully..", Toast.LENGTH_SHORT).show()

        }.addOnFailureListener {
            Toast.makeText(context, "Fail to update need : " + it.message, Toast.LENGTH_SHORT)
                .show()
        }
}

/*  Button(
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
                        updateDataToFirebase(
                            Title.value,
                            Localisation.value,
                            Sector.value,
                            Salary.value,context
                        )
                        navController.popBackStack()
                    }

                },
                colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue),
                shape = RoundedCornerShape(35),
                modifier = Modifier.width(125.dp)
            ) {
                Text(text = "Modify", color = Color.Black)
            }*/


