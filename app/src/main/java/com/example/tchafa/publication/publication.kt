package com.example.tchafa.publication

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
import com.example.tchafa.navigation.Screen
import com.example.tchafa.need.CustomPublicationDialog
import com.example.tchafa.need.needIndex
import com.example.tchafa.need.titre
import com.example.tchafa.start.Email
import com.example.tchafa.ui.theme.ComponentBlue
import com.example.tchafa.ui.theme.LightBlack
import com.example.tchafa.ui.theme.TextBlue
import com.example.tchafa.ui.theme.White
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun publicationHome(navController: NavController){
    val context = LocalContext.current

    var search by remember {
        mutableStateOf("")
    }

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    var needList = mutableStateListOf<Need?>()


    val showDialog =  remember { mutableStateOf(false) }

    if(showDialog.value)
        CustomPublicationDialog(value = "", setShowDialog = {
            showDialog.value = it
        }) {
            Log.i("HomePage","HomePage : $it")
        }
    /*-------------------------------------------*/
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    db.collection("Users").document("$Email").collection("Needs").get()
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
                    "No need found create one",
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
                    .padding(horizontal = 15.dp, vertical = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Image(painter = painterResource(R.drawable.back_arrow),
                    contentDescription = "back",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { navController.popBackStack() })
                Image(painter = painterResource(R.drawable.plus),
                    contentDescription = "sort",
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .rotate(90f)
                        .clickable { navController.navigate("need_detail_screen") }
                        .size(30.dp))
            }

            Text(text = "My Needs", color = TextBlue, fontSize = 35.sp, fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace)
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
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 15.dp)
                            .background(White)
                            .border(1.dp, color = LightBlack, shape = RoundedCornerShape(8.dp)),) {
                        Column(
                            Modifier
                                .width(80.dp)
                                .padding(top = 38.dp)
                                .fillMaxHeight(),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(painter = painterResource(id = R.drawable.no_image), contentDescription ="no image", modifier = Modifier.size(30.dp) )
                        }
                        Column {
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                                needList[index]?.Title?.let {
                                    Text(text = it, fontSize = 30.sp, color = TextBlue)
                                }
                                Image(painter = painterResource(id = R.drawable.next_arrow), contentDescription ="next", modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 8.dp)
                                    .clickable {
                                        titre = ""
                                        titre = needList[index]?.Title
                                        if (titre != "") {
                                            titre = needList[index]?.Title
                                            navController.navigate(route = Screen.NeedDetails.route)
                                        }
                                    })
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(verticalAlignment = Alignment.Bottom){
                                Column() {
                                    Row() {
                                        Image(
                                            painter = painterResource(id = R.drawable.sector),
                                            contentDescription = "sector",
                                        )
                                        needList[index]?.sector?.let{
                                            Text(
                                                text = it,
                                                color = Color.Black,
                                                modifier = Modifier.padding(start = 10.dp)
                                            )
                                        }
                                    }
                                    Spacer(Modifier.height(10.dp))
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Row() {
                                            Image(
                                                painter = painterResource(id = R.drawable.localisation),
                                                contentDescription = "sector"
                                            )
                                            needList[index]?.localisation?.let{
                                                Text(
                                                    text = it,
                                                    color = Color.Black,
                                                    modifier = Modifier.padding(start = 10.dp)
                                                )
                                            }
                                        }
                                        Button(onClick = {
                                            showDialog.value = true
                                            needIndex = index },
                                            modifier = Modifier
                                                .padding(end = 20.dp)
                                                .width(80.dp)
                                                .height(30.dp)
                                                .clip(shape = RoundedCornerShape(5.dp))
                                            ,
                                            colors = ButtonDefaults.buttonColors(
                                                backgroundColor = ComponentBlue
                                            )
                                        ) {
                                            Text(text = "Publish", color = White)
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                }
            }
        }
    }
}