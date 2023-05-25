package com.example.tchafa.publication

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.data.Need
import com.example.tchafa.data.Publication
import com.example.tchafa.navigation.Screen
import com.example.tchafa.need.CustomPublicationDialog
import com.example.tchafa.start.Email
import com.example.tchafa.ui.theme.*
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


var publishedBy :String? =""
@Composable
fun OLPublications(navController: NavController){
    val context = LocalContext.current

    var search by remember {
        mutableStateOf("")
    }

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    var needList = mutableStateListOf<Publication?>()


    val showDialog =  remember { mutableStateOf(false) }

    if(showDialog.value)
        CustomPublicationDialog(value = "", setShowDialog = {
            showDialog.value = it
        }) {
            Log.i("HomePage","HomePage : $it")
        }
    /*-------------------------------------------*/
    val db = Firebase.firestore
    val collectionRef = db.collection("Publications")
    val maListe = mutableListOf<DocumentSnapshot>()

    collectionRef.whereNotEqualTo("publishedBy", "$Email")
        .get()
        .addOnSuccessListener { queryDocumentSnapshots ->
            if (!queryDocumentSnapshots.isEmpty) {

                val list = queryDocumentSnapshots.documents
                for (d in list) {
                    val c: Publication? = d.toObject(Publication::class.java)

                    needList.add(c)
                }
            } else {

                Toast.makeText(
                    context,
                    "No publication found comeback later",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
/*---------------------------------------------*/
    Column(
        Modifier
            .fillMaxSize())
    {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 10.dp)) {
                Image(painter = painterResource(R.drawable.back_arrow),
                    contentDescription = "back",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { navController.popBackStack() })
            }

            Text(text = "Publications", color = TextBlue, fontSize = 35.sp, fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace)
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 10.dp,),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )
        {

            TextField(
                value = search,
                onValueChange = { newText -> search = newText },
                modifier = Modifier
                    .padding(bottom = 25.dp, top = 30.dp, end = 20.dp, start = 20.dp)
                    .height(46.dp)
                    .width(screenWidth - 40.dp)
                    .border(1.dp, color = LightBlack, shape = RoundedCornerShape(10.dp)),
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
                    unfocusedIndicatorColor = Color.Transparent,
                    textColor = Color.Black
                )
            )
        }
        LazyColumn(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)
        {
            itemsIndexed(needList) { index, item ->
                Column(
                    Modifier
                        .width(screenWidth - 40.dp)
                        .padding(vertical = 0.dp, horizontal = 0.dp)) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .background(White)
                            .border(1.dp, color = LightBlack, shape = RoundedCornerShape(8.dp)),) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 0.dp, start = 10.dp)){
                            Row(Modifier.background(LightGray).size(70.dp).clip(shape = RoundedCornerShape(8.dp)), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                                Image(painter = painterResource(id = R.drawable.no_image), contentDescription ="no image", modifier = Modifier.size(30.dp) )
                            }
                            Column() {
                                needList[index]?.Title?.let{
                                    Text(text = it, fontSize = 30.sp, color = TextBlue,modifier = Modifier.padding(start = 8.dp)
                                    )
                                }
                                needList[index]?.salaire?.let {
                                    Row(Modifier.padding(start = 9.dp),verticalAlignment = Alignment.CenterVertically) {
                                        Text(text = it, fontSize = 23.sp, color = Color.Black)
                                        Text(text = "FCFA", fontSize = 20.sp, color = Color.Black,modifier = Modifier.padding(start = 3.dp))
                                    }

                                }
                                Row(
                                    Modifier
                                        .width(screenWidth - 70.dp)
                                        .padding(start = 13.dp))
                                {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Image(
                                            painter = painterResource(id = R.drawable.sector),
                                            contentDescription = "sector",
                                            modifier = Modifier.size(12.dp)
                                        )
                                        needList[index]?.Secteur?.let{
                                            Text(
                                                text = it,
                                                color = TextBlack,
                                                modifier = Modifier.padding(start = 4.dp, end = 20.dp),
                                                fontSize = 15.sp
                                            )
                                        }
                                    }
                                    Row() {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Image(
                                                painter = painterResource(id = R.drawable.localisation),
                                                contentDescription = "sector",
                                                modifier = Modifier
                                                    .size(12.dp)
                                                    .padding(start = 0.dp)
                                            )
                                            needList[index]?.Localisation?.let{
                                                Text(
                                                    text = it,
                                                    color = TextBlack,
                                                    modifier = Modifier.padding(start = 4.dp),
                                                    fontSize = 15.sp
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp), horizontalArrangement = Arrangement.Center){
                            Button(onClick = {                                Identifiant = null
                                Identifiant = needList[index]?.id
                                if (Identifiant != null) {
                                    Identifiant = needList[index]?.id
                                    navController.navigate(route = Screen.OLPublicationsDetail.route)
                                } },
                                modifier = Modifier
                                    .padding(end = 40.dp)
                                    .width(100.dp)
                                    .height(30.dp)
                                    .clip(shape = RoundedCornerShape(5.dp))
                                ,
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = LightGray
                                )
                            ) {
                                Image(painter = painterResource(id = R.drawable.details), contentDescription = "details ")
                            }

                            Button(onClick = {
                                publishedBy = needList[index]?.PublishedBy
                                if (publishedBy != "") {
                                    publishedBy = needList[index]?.PublishedBy
                                    addDataToFirebase(Email.toString(),context )
                                }
                            },
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(30.dp)
                                    .clip(shape = RoundedCornerShape(5.dp))
                                ,
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = ComponentBlue
                                )
                            ) {
                                Text(text = "Candidate", color = White)
                            }
                        }
                    }
                }
            }
        }
    }
}