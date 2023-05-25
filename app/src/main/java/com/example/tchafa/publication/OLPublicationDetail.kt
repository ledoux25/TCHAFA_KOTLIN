package com.example.tchafa.publication

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.bar.bottomNav
import com.example.tchafa.data.Candidature
import com.example.tchafa.data.Publication
import com.example.tchafa.log.Content
import com.example.tchafa.log.TopBar
import com.example.tchafa.navigation.Screen
import com.example.tchafa.need.*
import com.example.tchafa.start.Email
import com.example.tchafa.ui.theme.*
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.random.Random

var name :String? = ""
var surname :String? = ""
var town :String? = ""
var language :String? = ""
var birthday :String? = ""

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OLPublicationDetail(navController: NavController)
{
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val context = LocalContext.current
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val docList = ArrayList<Map<String, Any>>()
    Identifiant = Identifiant
    val docRef = db.collection("Publications").document("$Identifiant")

    docRef.get().addOnSuccessListener { documentSnapshot ->
        if (documentSnapshot.exists()) {
            val docData = documentSnapshot.data

            Title = docData?.get("title").toString()
            Localisation = docData?.get("localisation").toString()
            Sector = docData?.get("secteur").toString()
            Description = docData?.get("description").toString()
            Salaire = docData?.get("salaire").toString()


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

    Scaffold(
        topBar = { /*TODO*/ },
        content = {     Column(
            Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Identifiant = Identifiant
            Row(
                Modifier
                    .padding(vertical = 10.dp, horizontal = 15.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(painter = painterResource(R.drawable.back_arrow),
                    contentDescription = "back",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            docList.clear()
                            navController.popBackStack()
                        })
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Publication Detail", color = TextBlue, fontSize = 35.sp, fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace)
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp), horizontalArrangement = Arrangement.Center) {
                Column(
                    Modifier
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(LightGray)
                        .size(120.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id = R.drawable.no_image), contentDescription ="no image", modifier = Modifier.size(30.dp) )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = Title.toString(), color = Color.Black, fontSize = 28.sp, fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace, textDecoration = TextDecoration.Underline)
                // Do something with the title and localisation
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                Modifier
                    .width(screenWidth - 40.dp)
                    .height(screenHeight / 6.5f)
                    .border(1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)))
            {
                Column(
                    Modifier
                        .width(screenWidth / 2.32f)
                        .padding(vertical = 20.dp)
                        .fillMaxHeight(), verticalArrangement = Arrangement.SpaceAround,horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(id = R.drawable.localisation_blue), contentDescription = "localisation",modifier = Modifier.size(30.dp))
                    Text(
                        text = "Localisation",
                        color = TextBlack,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Monospace
                    )

                    Text(text = Localisation.toString(),
                        color = Color.Black,
                        fontSize = 28.sp,
                        fontFamily = FontFamily.Monospace,)
                }
                Spacer(modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
                    .background(Color.Black))
                Column(
                    Modifier
                        .width(screenWidth / 2.3f)
                        .padding(vertical = 20.dp)
                        .fillMaxHeight(), verticalArrangement = Arrangement.SpaceAround,horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(id = R.drawable.sector_blue), contentDescription = "localisation", modifier = Modifier.size(30.dp))
                    Text(text = "Sector",
                        color = TextBlack,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Monospace,)

                    Text(
                        text = Sector.toString(),
                        color = Color.Black,
                        fontSize = 28.sp,
                        fontFamily = FontFamily.Monospace,
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                Modifier
                    .height(screenHeight / 6f)) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp)){
                    Text(text = "Description",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 25.sp,
                        textDecoration = TextDecoration.Underline
                    )
                }
                OutlinedTextField(
                    value = Description.toString(),
                    onValueChange = { /*TODO*/ },
                    modifier = Modifier
                        .width(screenWidth - 25.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        textColor = Color.Black
                    )
                )

            }
            Spacer(modifier = Modifier.height(0.dp))
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = Salaire.toString(), fontSize = 33.sp, color = TextBlue, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
            }
            Spacer(modifier = Modifier.height(55.dp))
            Row(Modifier.width(screenWidth-60.dp), horizontalArrangement = Arrangement.Center) {
                Button(
                    onClick = {
                        addDataToFirebase(Email.toString(),context)
                        Identifiant = null
                        docList.clear()
                        navController.navigate(Screen.NeedHome.route)
                    },
                    modifier = Modifier
                        .width(screenWidth / 2.5f)
                        .height(45.dp)
                        .clip(shape = RoundedCornerShape(5.dp)),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = ComponentBlue
                    )
                ) {
                    Text(
                        text = "Candidate",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                }
            }
        }
                  },
        bottomBar = { bottomNav(navController = navController) }
    )

}

@Composable
fun CustomCandidatureDialog(value: String, setShowDialog: (Boolean) -> Unit, setValue: (String) -> Unit) {

    val email = remember { mutableStateOf(value) }
    val context = LocalContext.current
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val docList = ArrayList<Map<String, Any>>()

    val docRef = db.collection("Users").document("$Email")

    docRef.get().addOnSuccessListener { documentSnapshot ->
        if (documentSnapshot.exists()) {
            val docData = documentSnapshot.data

            name = docData?.get("name").toString()
            surname = docData?.get("surname").toString()
            town = docData?.get("town").toString()
            language = docData?.get("langue").toString()
            birthday = docData?.get("birthday").toString()

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
                                text = "Add Candidature",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "(add your email)",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily.Default,
                                )
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

                    Spacer(modifier = Modifier.height(20.dp))
                    Column() {
                        Text(text = "Enter your E-mail",color = Color.Black, fontSize = 20.sp)
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(45.dp)
                                .border(
                                    BorderStroke(
                                        width = 2.dp,
                                        color = LightBlack
                                    ),
                                    shape = RoundedCornerShape(8)
                                ),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            placeholder = {  },
                            value = email.value,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            onValueChange = {
                                email.value = it
                            })
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {

                                if (email.value.isEmpty()) {
                                    email.value = "Fill the infos"
                                    return@Button
                                }else if(email.value.toString() != Email){
                                    email.value = "This is not your e-mail"
                                }else{
                                    addDataToFirebase(
                                        Email.toString(),
                                        context
                                    )
                                    setShowDialog(false)
                                }

                            },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(45.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue)
                        ) {
                            Text(text = "Candidate", fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace, color = White, fontSize = 22.sp)
                        }
                    }
                }
            }
        }
    }
}

fun addDataToFirebase(
    email :String,
    context: Context
) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val dbPublic: DocumentReference = db.collection("Users").document("$publishedBy").collection("Publications").document("$Identifiant").collection("Candidatures").document("$email")
    val Candis = Candidature(email)
    dbPublic.set(Candis).addOnSuccessListener {
        Toast.makeText(
            context,
            "Your candidacy has added",
            Toast.LENGTH_SHORT
        ).show()

    }.addOnFailureListener { e ->
        Toast.makeText(context, "Fail to add your candidacy \n$e", Toast.LENGTH_SHORT).show()

    }
    val dbPublics: DocumentReference =
        db.collection("Publications").document("$Identifiant").collection("Candidatures").document("$email")
    val candis = Candidature(email)
    dbPublics.set(candis).addOnSuccessListener {

    }.addOnFailureListener { e ->
    }
}