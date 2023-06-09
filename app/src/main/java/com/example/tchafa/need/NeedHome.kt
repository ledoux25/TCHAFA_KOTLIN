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
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
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
import com.example.tchafa.bar.bottomNav
import com.example.tchafa.data.Need
import com.example.tchafa.data.Publication
import com.example.tchafa.data.Recommendation
import com.example.tchafa.log.Content
import com.example.tchafa.log.TopBar
import com.example.tchafa.navigation.Screen
import com.example.tchafa.recommendations.CustomDialog
import com.example.tchafa.start.Email
import com.example.tchafa.ui.theme.*
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import java.sql.RowId
import kotlin.random.Random

public var needIndex : Int? = null
var titre :String? = ""

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun NeedHomeScreen(navController: NavController){
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

    Scaffold(
        topBar = { /*TODO*/},
        content = {     Column(
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
                        textColor = Black
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
                                                    color = Black,
                                                    modifier = Modifier.padding(start = 10.dp)
                                                )}
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
                                                        color = Black,
                                                        modifier = Modifier.padding(start = 10.dp)
                                                    )}
                                            }
                                            Button(onClick = {
                                                titre = ""
                                                titre = needList[index]?.Title
                                                if (titre != "") {
                                                    titre = needList[index]?.Title
                                                    showDialog.value = true
                                                    needIndex = index
                                                } },
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
        } },
        bottomBar = { bottomNav(navController = navController) }
    )

    }


@Composable
fun CustomPublicationDialog(value: String, setShowDialog: (Boolean) -> Unit, setValue: (String) -> Unit) {

    val duree = remember { mutableStateOf(value) }
    val Salaire = remember { mutableStateOf(value) }
    val context = LocalContext.current
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
                                text = "Create Publication",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "(Add complementary data)",
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
                        Text(text = "Enter duration (in days)",color = Black, fontSize = 20.sp)
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
                            value = duree.value,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            onValueChange = {
                                duree.value = it
                            })
                    }


                    Spacer(modifier = Modifier.height(20.dp))
                    Column() {
                        Text(text = "Enter Salary (in Fcfa)",color = Black, fontSize = 20.sp)
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
                            value = Salaire.value,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            onValueChange = {
                                Salaire.value = it
                            })
                    }



                    Spacer(modifier = Modifier.height(20.dp))

                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                var randomNumber = Random.nextInt(1,1000000)
                                if (Salaire.value.isEmpty()) {
                                    Salaire.value = "Fill the infos"
                                    return@Button
                                }else if(duree.value.isEmpty()) {
                                    duree.value = "Fill the infos"
                                    return@Button
                                }else if(duree.value.toInt() > 30) {
                                    duree.value = "Not more than 30 days"
                                }else{
                                    addDataToFirebase(
                                        title.toString(),
                                        localisation.toString(),
                                        sector.toString(),
                                        description.toString(),
                                        duree.value,
                                        Salaire.value,
                                        Email.toString(),
                                        randomNumber,
                                        context
                                    )
                                    setValue(duree.value)
                                    setShowDialog(false)
                                }

                            },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(45.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue)
                        ) {
                            Text(text = "Save", fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace, color = White, fontSize = 22.sp)
                        }
                    }
                }
            }
        }
    }
}

fun addDataToFirebase(
    Title :String,
    Localisation :String,
    Secteur : String,
    Description :String,
    Duree: String,
    Salaire: String,
    PublishedBy: String,
    randomNumber :Int,
    context: Context
) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val dbPublic: DocumentReference = db.collection("Users").document("$Email").collection("Publications").document("$randomNumber")
    val publics = Publication(randomNumber,PublishedBy,Title,Localisation,Secteur,Description,Duree,Salaire)
    dbPublic.set(publics).addOnSuccessListener {
        Toast.makeText(
            context,
            "Your Publication has been saved added",
            Toast.LENGTH_SHORT
        ).show()

    }.addOnFailureListener { e ->
        Toast.makeText(context, "Fail to add publication \n$e", Toast.LENGTH_SHORT).show()

    }
    val dbPublics: DocumentReference =
        db.collection("Publications").document("$randomNumber")
    val public = Publication(
        randomNumber,
        PublishedBy,
        Title,
        Localisation,
        Secteur,
        Description,
        Duree,
        Salaire
    )
    dbPublics.set(public).addOnSuccessListener {
        Toast.makeText(
            context,
            "Your Publication has been saved added",
            Toast.LENGTH_SHORT
        ).show()

    }.addOnFailureListener { e ->
        Toast.makeText(context, "Fail to add publication \n$e", Toast.LENGTH_SHORT).show()
    }
}


/*                        Column(
                            Modifier
                                .fillMaxWidth()
                                .height((screenHeight / 3) - 5.dp)
                                .padding(horizontal = 13.dp, vertical = 10.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                                .background(White)
                        )
                        {

                            Row(
                                Modifier
                                    .padding(top = 13.dp, bottom = 5.dp)
                                    .fillMaxWidth(),
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
                                    val index = needList[index]
                                    titre
                                    OutlinedTextField(
                                        modifier = Modifier
                                            .width(screenWidth - 40.dp)
                                            .height((screenHeight / 6.5f) - 20.dp)
                                            .padding(5.dp)
                                            .clip(shape = RoundedCornerShape(20.dp))
                                            .border(
                                                color = Color.Transparent,
                                                width = 1.dp,
                                                shape = RoundedCornerShape(20.dp)
                                            )
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
                                            titre = needList[index]?.Title

                                        deleteDataFromFirebase(titre, context,navController)
                                    },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue),
                                    shape = RoundedCornerShape(35),
                                    modifier = Modifier.width(80.dp)
                                ) {
                                    Text(text = "Delete", color = Color.Black)
                                }
                                Button(
                                    onClick = {
                                        titre = needList[index]?.Title
                                        navController.navigate(route = Screen.NeedModifyView.route)
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
                        }*/