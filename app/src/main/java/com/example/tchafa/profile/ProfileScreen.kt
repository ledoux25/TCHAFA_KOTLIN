package com.example.tchafa.profile

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.navigation.Screen
import com.example.tchafa.need.CustomPublicationDialog
import com.example.tchafa.start.Email
import com.example.tchafa.ui.theme.*
import com.google.firebase.firestore.FirebaseFirestore

var NAME :String? = ""
var SURNAME :String? = ""
var TOWN :String? = ""
var ANNIV :String? = ""
var LANGUAGE :String? = ""

@Composable
fun ProfileScreen(navController: NavController){
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    val showDialog =  remember { mutableStateOf(false) }

    if(showDialog.value)
        CustomProfileDialog(navController = navController,value = "", setShowDialog = {
            showDialog.value = it
        }) {
            Log.i("HomePage","HomePage : $it")
        }

    Column(
        Modifier
            .background(White)
            .padding(horizontal = 15.dp)
            .fillMaxSize(),
    ){
        Row(
            Modifier
                .padding(vertical = 10.dp, horizontal = 5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(R.drawable.back_arrow),
                contentDescription = "back",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { navController.popBackStack() })

            Text(text = "Public Profile", color = TextBlue, fontSize =  28.sp, fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace)

            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = "notif_button",
                tint = ComponentBlue,
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        Row(Modifier.fillMaxWidth()){
            Row(modifier = Modifier.width(190.dp).clip(shape = RoundedCornerShape(8.dp)).padding(horizontal = 10.dp).height(90.dp).background(BackgroundGray), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){Image(painter = painterResource(id = R.drawable.no_image), contentDescription ="no image", modifier = Modifier.size(30.dp))}
            Column(Modifier.height(96.dp), verticalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Justin Nah", fontWeight = FontWeight.Medium , fontSize = 22.sp)
                Text(text = "jutinnah@gmail.com", fontSize = 15.sp, color = TextBlack)
                Button(
                    onClick = {
                        showDialog.value = true
                              },
                    modifier = Modifier.width(130.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = ComponentBlue
                    )
                ) {
                    Text(
                        text = "View Profile",
                        color = White,
                        fontSize = 14.sp
                    )
                }
            }
        }
        Column() {

            Spacer(modifier = Modifier.height(40.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row() {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "notif_button",
                        tint = Color.Black,
                    )
                    Text(text = "Personal nformations", fontSize = 20.sp, fontFamily = FontFamily.Monospace, modifier = Modifier.padding(start = 5.dp))
                }
                Image(painter = painterResource(id = R.drawable.next_black), contentDescription = "yes")
            }

            Spacer(modifier = Modifier.height(31.dp))

            Row(Modifier.fillMaxWidth().clickable { navController.navigate(Screen.RecommendationHome.route) }, horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
                Row() {
                    Image(painter = painterResource(id = R.drawable.recommendation_black), contentDescription = "bg", modifier = Modifier.size(25.dp))
                    Text(text = "My recommendations", fontSize = 20.sp, fontFamily = FontFamily.Monospace, modifier = Modifier.padding(start = 5.dp))
                }
                Image(painter = painterResource(id = R.drawable.next_black), contentDescription = "yes")
            }

            Spacer(modifier = Modifier.height(27.dp))


            Row(Modifier.fillMaxWidth().clickable { navController.navigate(Screen.NeedHome.route) }, horizontalArrangement = Arrangement.SpaceBetween) {
                Row() {
                    Image(painter = painterResource(id = R.drawable.need_black), contentDescription = "bg",modifier = Modifier.size(25.dp))

                    Text(text = "My needs", fontSize = 20.sp, fontFamily = FontFamily.Monospace, modifier = Modifier.padding(start = 5.dp))
                }
                Image(painter = painterResource(id = R.drawable.next_black), contentDescription = "yes")
            }
            Spacer(modifier = Modifier.height(31.dp))

            Row(Modifier.fillMaxWidth().clickable { navController.navigate(Screen.publicationHome.route) }, horizontalArrangement = Arrangement.SpaceBetween) {
                Row() {
                    Image(painter = painterResource(id = R.drawable.publication_black), contentDescription = "bg",modifier = Modifier.size(25.dp))
                    Text(text = "My publications", fontSize = 20.sp, fontFamily = FontFamily.Monospace, modifier = Modifier.padding(start = 5.dp))
                }
                Image(painter = painterResource(id = R.drawable.next_black), contentDescription = "yes")
            }

            Spacer(modifier = Modifier.height(275.dp))

            Row(Modifier.fillMaxWidth().clickable { navController.navigate(Screen.LoginHome.route) }, horizontalArrangement = Arrangement.SpaceBetween) {
                Row() {
                    Image(painter = painterResource(id = R.drawable.logout_black), contentDescription = "bg",modifier = Modifier.size(25.dp))
                    Text(text = "Logout", fontSize = 20.sp, fontFamily = FontFamily.Monospace, modifier = Modifier.padding(start = 5.dp))
                }
            }
        }
    }
}

@Composable
fun CustomProfileDialog(value: String,navController: NavController, setShowDialog: (Boolean) -> Unit, setValue: (String) -> Unit) {

    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val context = LocalContext.current
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val docList = ArrayList<Map<String, Any>>()

    val docRef = db.collection("Users").document("$Email")

    docRef.get().addOnSuccessListener { documentSnapshot ->
        if (documentSnapshot.exists()) {
            val docData = documentSnapshot.data

            NAME = docData?.get("name").toString()
            SURNAME = docData?.get("surname").toString()
            TOWN = docData?.get("town").toString()
            ANNIV = docData?.get("birthday").toString()
            LANGUAGE = docData?.get("langue").toString()




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



    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column() {
                            Text(
                                text = "My profile",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.Bold
                                ),
                                color = TextBlue
                            )
                        }

                        Icon(
                            imageVector = Icons.Filled.Cancel,
                            contentDescription = "",
                            tint = colorResource(android.R.color.darker_gray),
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable { setShowDialog(false) }
                        )
                    }

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
                                    value = NAME.toString(),
                                    onValueChange = { NAME.toString() },
                                    singleLine = true,
                                    modifier = Modifier
                                        .width(screenWidth / 3f)
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
                                    value = SURNAME.toString(),
                                    onValueChange = { SURNAME.toString() },
                                    singleLine = true,
                                    modifier = Modifier
                                        .width(screenWidth / 3f)
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
                        }
                        OutlinedTextField(
                            value = ANNIV.toString(),
                            onValueChange = { ANNIV.toString() },
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
                            value = TOWN.toString(),
                            onValueChange = { TOWN.toString() },
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
                        }
                        OutlinedTextField(
                            value = LANGUAGE.toString(),
                            onValueChange = { LANGUAGE.toString() },
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
                    Spacer(modifier = Modifier.height(20.dp))

                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                      navController.navigate(Screen.ProfileForm.route)
                            },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(45.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue)
                        ) {
                            Text(text = "Modify", fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace, color = White, fontSize = 22.sp)
                        }
                    }
                }
            }
        }
    }
}