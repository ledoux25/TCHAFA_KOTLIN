package com.example.tchafa.need

import android.content.ContentValues
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.navigation.Screen
import com.example.tchafa.start.Email
import com.example.tchafa.ui.theme.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


var Title :String? = ""
var Sector :String? = ""
var Localisation :String? = ""
var Description :String? = ""


@Composable
fun NeedDetails(navController: NavController){
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val context = LocalContext.current
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val docList = ArrayList<Map<String, Any>>()

    val showDialog =  remember { mutableStateOf(false) }

    if(showDialog.value)
        CustomPublicationDialog(value = "", setShowDialog = {
            showDialog.value = it
        }) {
            Log.i("HomePage","HomePage : $it")
        }

    titre = titre
    val docRef = db.collection("Users").document("$Email").collection("Needs").document("$titre")

    docRef.get().addOnSuccessListener { documentSnapshot ->
        if (documentSnapshot.exists()) {
            val docData = documentSnapshot.data

            Title = docData?.get("title").toString()
            Localisation = docData?.get("localisation").toString()
            Sector = docData?.get("sector").toString()
            Description = docData?.get("description").toString()



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
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {
        titre = titre
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
            Image(painter = painterResource(R.drawable.modify),
                contentDescription = "Modify",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {

                        if(titre != ""){
                            titre = titre
                            navController.navigate(Screen.NeedModifyView.route)
                        }

                    })
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "Need Detail", color = TextBlue, fontSize = 35.sp, fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace)
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
                .border(1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))) {
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
                .height(screenHeight / 5f)) {
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
        Spacer(modifier = Modifier.height(35.dp))
        Row(Modifier.width(screenWidth-60.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = {
                        showDialog.value = true
                },
                modifier = Modifier
                    .width(screenWidth/2.5f)
                    .height(45.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = ComponentBlue
                )
            ) {
                Text(
                    text = "Publish",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = White
                )
            }

            Button(
                onClick = {
                    deleteDataFromFirebase(titre, context)
                    title = ""
                    docList.clear()
                    navController.navigate(Screen.NeedHome.route)
                          },
                modifier = Modifier
                    .width(screenWidth/2.5f)
                    .height(45.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Red
                )
            ) {
                Text(
                    text = "Delete",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = White
                )
            }
        }

    }
}
private fun deleteDataFromFirebase(titre: String?, context: Context) {

    val db = FirebaseFirestore.getInstance();
    db.collection("Users").document("$Email").collection("Needs").document("$titre").delete().addOnSuccessListener {
        Toast.makeText(context, "Needd Deleted successfully..", Toast.LENGTH_SHORT).show()
    }.addOnFailureListener {
        // on below line displaying toast message when
        // we are not able to delete the course
        Toast.makeText(context, "Fail to delete need..", Toast.LENGTH_SHORT).show()
    }

}