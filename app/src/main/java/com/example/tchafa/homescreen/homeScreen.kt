package com.example.tchafa.homescreen

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.components.BottomNavigationBar
import com.example.tchafa.components.TopBar
import com.example.tchafa.navigation.sidebarNav
import com.example.tchafa.ui.theme.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Composable
fun homeScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    lateinit var database: DatabaseReference
// ...
    database = Firebase.database.reference

    @IgnoreExtraProperties
    data class User(val username: String? = null, val email: String? = null) {
        // Null default values create a no-argument default constructor, which is needed
        // for deserialization from a DataSnapshot.
    }

    fun writeNewUser(userId: String, name: String, email: String) {
        val user = User(name, email)

        database.child("users").child(userId).setValue(user)
    }

    val navigation = listOf(
        sidebarNav.Needs,
        sidebarNav.Pubs,
        sidebarNav.Recoms,
        sidebarNav.Candis
    )
    val context = LocalContext.current
    var search by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = { TopBar() },
        drawerContent = {},
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .background(White)) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(screenHeight / 5.5f),

                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(Modifier.fillMaxWidth().padding(start = 10.dp), verticalArrangement = Arrangement.Center) {
                        Text(text = "Find your partime",
                            color = Background,
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace
                        )
                        Text(text = "Earning job",
                            color = Background,
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace)
                    }

                }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp,),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                TextField(
                    value = search,
                    onValueChange = { newText -> search = newText },
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .height(46.dp)
                        .width(screenWidth - 40.dp)
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
            Column(
                Modifier
                    .width(screenWidth)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .padding(vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Recent Publications", color = Color.Black , fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Medium, fontSize = 32.sp )
                Row(Modifier
                    .horizontalScroll(rememberScrollState())
                ){
                    Row(
                        modifier = Modifier.padding(vertical = 15.dp)
                    ){
                        Row(
                            Modifier
                                .width(screenWidth  - 20.dp)
                                .height(155.dp)
                                .background(LightGray)
                                .padding(horizontal = 8.dp,)
                                .clip(shape = RoundedCornerShape(15.dp)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = "No Publications found", color = Color.Black , fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Medium, fontSize = 24.sp )
                        }
                    }

                }
            }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,){
                Text(
                    text = "Ongoing Task", color = Color.Black, fontSize = 28.sp, modifier = Modifier.padding(bottom = 15.dp)
                )
                Column(
                    Modifier
                        .width(screenWidth - 20.dp)
                        .height(155.dp)
                        .background(LightGray)
                        .clip(shape = RoundedCornerShape(15.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "No ongoing task found", color = Color.Black , fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Medium, fontSize = 24.sp )
                }
            }
        }
    }
}

/*
@Composable
fun  Drawer(menu_items: List<sidebarNav>){

    Column() {
        Image(painter = painterResource(id = R.drawable.work_image),
            contentDescription = "bg",
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(15.dp))
        menu_items.forEach{item ->
            TextButton(onClick = {/*TODO*/}) {
                DrawerItem(item = item)
            }
        }
    }
}

@Composable
fun DrawerItem(item :sidebarNav){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(15.dp))
            .padding(8.dp)
            ){
        Image(painterResource(id = item.icon),
            contentDescription = item.title)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = item.title,
        style =  MaterialTheme.typography.body1,
        )
    }
}
*/
