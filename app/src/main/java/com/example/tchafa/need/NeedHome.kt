package com.example.tchafa.need

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
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
import com.example.tchafa.data.Need
import com.example.tchafa.data.Publication
import com.example.tchafa.data.Recommendation
import com.example.tchafa.navigation.Screen
import com.example.tchafa.recommendations.CustomDialog
import com.example.tchafa.start.Email
import com.example.tchafa.ui.theme.*
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

public var needIndex : Int? = null

@Composable
@SuppressLint("UnrememberedMutableState")
fun NeedHomeScreen(navController: NavController){
    val context = LocalContext.current

    var search by remember {
        mutableStateOf("")
    }

    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    var needList = mutableStateListOf<Need?>()
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()

    val showDialog =  remember { mutableStateOf(false) }

    if(showDialog.value)
        CustomDialog(value = "", setShowDialog = {
            showDialog.value = it
        }) {
            Log.i("HomePage","HomePage : $it")
        }

    db.collection("Needs").get()
        .addOnSuccessListener { queryDocumentSnapshots ->
            if (!queryDocumentSnapshots.isEmpty) {

                val list = queryDocumentSnapshots.documents
                for (d in list) {
                    val c: Need? = d.toObject(Need::class.java)

                    needList.add(c)

                }
            } else {

                Toast.makeText(
                    context,
                    "No data found in Database",
                    Toast.LENGTH_SHORT
                ).show()
            }
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
            .background(BackgroundGray)
            .fillMaxSize())
    {
        Column(
            Modifier
                .fillMaxWidth()
                .height((screenHeight / 6))
                .background(Background),
            horizontalAlignment = Alignment.Start
        ){
            Image(painter = painterResource(R.drawable.back_arrow), contentDescription = "back", modifier = Modifier
                .padding(start = 7.dp)
                .size(50.dp)
                .clickable { navController.popBackStack() })
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "Needs", fontSize = 42.sp, fontWeight = FontWeight.Medium, color = White)
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
                    .clickable { navController.navigate("need_detail_screen") }
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
                    unfocusedIndicatorColor  = Color.Transparent,
                    textColor = Black
                )
            )
            }
                LazyColumn()
                {
                    itemsIndexed(needList){index, item ->

                        Column(
                            Modifier
                                .fillMaxWidth()
                                .height((screenHeight / 3) - 5.dp)
                                .padding(horizontal = 13.dp, vertical = 10.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                                .background(White)
                        )
                        {

                            Row(
                                Modifier.padding(top = 13.dp, bottom = 5.dp).fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                needList[index]?.sector?.let{
                                    Text(
                                        text = it,
                                        modifier = Modifier
                                            .width(100.dp)
                                            .border(1.dp, LightBlack, RoundedCornerShape(20.dp))
                                            .clip(shape = RoundedCornerShape(20.dp))
                                            .background(LightGray)
                                            .padding(10.dp),
                                        textAlign = TextAlign.Center
                                    )
                                }

                                needList[index]?.localisation?.let{
                                    Text(
                                        text = it,
                                        modifier = Modifier
                                            .width(100.dp)
                                            .border(1.dp, LightBlack, RoundedCornerShape(20.dp))
                                            .clip(shape = RoundedCornerShape(20.dp))
                                            .background(LightGray)
                                            .padding(10.dp),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                                needList[index]?.Description?.let{
                                    OutlinedTextField(
                                        modifier = Modifier
                                            .width(screenWidth - 40.dp)
                                            .height((screenHeight/6.5f) - 20.dp)
                                            .padding(5.dp)
                                            .clip(shape = RoundedCornerShape(20.dp))
                                            .border(color = Color.Transparent, width = 1.dp, shape = RoundedCornerShape(20.dp))
                                            .background(LightGray),
                                        shape = RoundedCornerShape(5.dp),
                                        value = it,
                                        onValueChange = { TODO() },
                                        maxLines = 3,
                                        textStyle = MaterialTheme.typography.caption,
                                        colors = TextFieldDefaults.outlinedTextFieldColors(
                                            focusedBorderColor = Color.Transparent,
                                            unfocusedBorderColor = Color.Transparent,
                                            textColor = Black
                                        )
                                    )
                            }

                                }

                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Button(
                                    onClick = {

                                    },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue),
                                    shape = RoundedCornerShape(35),
                                    modifier = Modifier.width(80.dp)
                                ) {
                                    Text(text = "Delete", color = Color.Black)
                                }
                                Button(
                                    onClick = {
                                        navController.navigate(route = Screen.NeedDetail.route)
                                    },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue),
                                    shape = RoundedCornerShape(35),
                                    modifier = Modifier.width(80.dp)
                                ) {
                                    Text(text = "Modify", color = Color.Black)
                                }
                                Button(
                                    onClick = {
                                        showDialog.value = true
                                        needIndex = index
                                    },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue),
                                    shape = RoundedCornerShape(35),
                                    modifier = Modifier.width(80.dp)
                                ) {
                                    Text(text = "Publish", color = Color.Black)
                                }
                            }
                        }
                    }
            }
        }
}


@Composable
fun CustomPublicationDialog(value: String, setShowDialog: (Boolean) -> Unit, setValue: (String) -> Unit) {

    val duree = remember { mutableStateOf(value) }
    val Salaire = remember { mutableStateOf(value) }
    val context = LocalContext.current



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
                        Text(
                            text = "Create recommendation",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Bold
                            )
                        )
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
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        placeholder = { Text(text = "Enter Phone Number",color = LightBlack, fontSize = 20.sp) },
                        value = Salaire.value,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        onValueChange = {
                            Salaire.value = it
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
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        placeholder = { Text(text = "Enter Description",color = LightBlack, fontSize = 20.sp) },
                        value = duree.value,
                        onValueChange = {
                            duree.value = it
                        })

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                if (Salaire.value.isEmpty()) {
                                    Salaire.value = "Field can not be empty"
                                    return@Button
                                }else if(duree.value.isEmpty()){
                                    duree.value = "Field can not be empty"
                                    return@Button
                                }else{
                                    addDataToFirebase(
                                        duree.value,
                                        Salaire.value,
                                        context
                                    )
                                    setValue(duree.value)
                                    setShowDialog(false)
                                }

                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue)
                        ) {
                            Text(text = "Save", fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace)
                        }
                    }
                }
            }
        }
    }
}

fun addDataToFirebase(
    Duree: String,
    Salaire: String,
    context: Context
) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val dbNeed: CollectionReference = db.collection("Users").document("$Email").collection("Recoms")
    val recoms = Publication(Duree,Salaire)
    dbNeed.add(recoms).addOnSuccessListener {
        Toast.makeText(
            context,
            "Your Publication has been saved added",
            Toast.LENGTH_SHORT
        ).show()

    }.addOnFailureListener { e ->
        Toast.makeText(context, "Fail to add publication \n$e", Toast.LENGTH_SHORT).show()
    }

}