package com.example.tchafa.recommendations

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.components.rememberImeState
import com.example.tchafa.data.Need
import com.example.tchafa.data.Recommendation
import com.example.tchafa.navigation.Screen
import com.example.tchafa.need.titre
import com.example.tchafa.start.Email
import com.example.tchafa.ui.theme.*
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

var name :String? =""

@Composable
@SuppressLint("UnrememberedMutableState")
fun PublicationHome(navController: NavController) {

    val imeState = rememberImeState()
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    var recomList = mutableStateListOf<Recommendation?>()
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    var search by remember {
        mutableStateOf("")
    }

    db.collection("Users").document("$Email").collection("Recoms").get()
        .addOnSuccessListener { queryDocumentSnapshots ->
            if (!queryDocumentSnapshots.isEmpty) {
                val list = queryDocumentSnapshots.documents
                for (d in list) {
                    val c: Recommendation? = d.toObject(Recommendation::class.java)
                    recomList.add(c)

                }
            } else {
                Toast.makeText(
                    context,
                    "No data found in Database",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        .addOnFailureListener {
            Toast.makeText(
                context,
                "Fail to get the data.",
                Toast.LENGTH_SHORT
            ).show()
        }

    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value) {
            scrollState.scrollTo(scrollState.maxValue)
        }
    }

    val showDialog =  remember { mutableStateOf(false) }

    if(showDialog.value)
        CustomDialog(value = "", setShowDialog = {
            showDialog.value = it
        }) {
            Log.i("HomePage","HomePage : $it")
        }

    Column(
        Modifier
            .background(LightGreen)
            .fillMaxSize()
    ) {
        Column(
            Modifier
                .height(screenHeight / 6)
                .fillMaxWidth()
                .background(Background)
        )
        {
            Image(
                painter = painterResource(R.drawable.back_arrow),
                contentDescription = "back",
                modifier = Modifier
                    .padding(start = 7.dp)
                    .size(40.dp)
                    .clickable { navController.popBackStack() }
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Publications",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Medium,
                    color = White
                )
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 10.dp,),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Image(painter = painterResource(R.drawable.plus), contentDescription = "sort", modifier = Modifier
                .padding(start = 20.dp)
                .rotate(90f)
                .clickable { navController.navigate("search")
                    Toast.makeText(context,"Choose the need you want to publish",Toast.LENGTH_LONG)
                }
                .size(30.dp))
            TextField(
                value = search,
                onValueChange = { newText -> search = newText },
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .height(46.dp)
                    .width(screenWidth - 80.dp)
                    .border(1.dp, color = LightBlack, shape = RoundedCornerShape(25.dp)),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search"
                    )
                },
                label = { Text(text = "Search", color = LightBlack, fontSize = 12.sp) },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontFamily = FontFamily.Monospace
                ),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor  = Color.Transparent
                )
            )
        }

        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(top = 20.dp))
        {
            itemsIndexed(recomList) { index, item ->
                Column(
                    Modifier
                        .clip(shape = RoundedCornerShape(5.dp))
                        .background(Color.White)
                        .height(screenHeight / 5.5F)
                        .width(screenWidth - 25.dp)
                        .padding(top = 7.5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                    ) {
                        Column(
                            Modifier
                                .width((screenWidth) / 2.7f)
                                .padding(start = 25.dp)) {
                                Text(
                                    text = "Plombier",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.W300,
                                )
                                Text(
                                    text = "Douala",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.W300,
                                )

                        }
                        Row(Modifier.padding(top = 2.dp)) {
                                Text(
                                    text = "30000Frs",
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 28.sp,
                                    color = Background
                                )
                            Spacer(modifier = Modifier.width(50.dp))
                            Icon(
                                imageVector = Icons.Filled.Delete,
                                contentDescription = "",
                                tint = colorResource(android.R.color.holo_red_light),
                                modifier = Modifier
                                    .width(28.dp)
                                    .height(28.dp)
                                    .padding(start = 4.dp, top = 2.dp)
                                    .clickable {  }
                            )
                        }
                    }
                    recomList[index]?.Recommendation?.let {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(65.dp)
                                .padding(start = 15.dp, end = 15.dp)
                                .clip(shape = RoundedCornerShape(20.dp))
                                .background(LightGray),
                            shape = RoundedCornerShape(5.dp),
                            value = it,
                            onValueChange = { TODO() },
                            maxLines = 3,
                            textStyle = MaterialTheme.typography.caption,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent
                            )
                        )
                    }

                }
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

private fun deleteDataFromFirebase(titre: String?, context: Context, navController: NavController) {

    val db = FirebaseFirestore.getInstance();
    db.collection("Users").document("$Email").collection("Needs").document("$titre").delete().addOnSuccessListener {
        Toast.makeText(context, "Needd Deleted successfully..", Toast.LENGTH_SHORT).show()
        navController.navigate(navController.currentDestination!!.id)
    }.addOnFailureListener {
        // on below line displaying toast message when
        // we are not able to delete the course
        Toast.makeText(context, "Fail to delete need..", Toast.LENGTH_SHORT).show()
    }

}



