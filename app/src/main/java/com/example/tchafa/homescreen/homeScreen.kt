package com.example.tchafa.homescreen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
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

    Scaffold(
        topBar = { TopBar() },
        drawerContent = {Drawer(menu_items = navigation)},
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
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = "Find Your")

                }
            
            Column(
                Modifier
                    .width(screenWidth)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .padding(vertical = 10.dp)
                    .background(LightGray),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Recent Publications", color = Color.Black, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Medium, fontSize = 26.sp )
                Row(Modifier
                    .horizontalScroll(rememberScrollState())
                ){
                    Row(
                        modifier = Modifier.padding(vertical = 15.dp)
                    ){
                        Card(
                            Modifier
                                .width((screenWidth / 2) - 20.dp)
                                .height(155.dp)
                                .padding(horizontal = 8.dp,)
                        ) {
                        }
                        Card(
                            Modifier
                                .width((screenWidth / 2) - 20.dp)
                                .height(155.dp)
                                .padding(horizontal = 5.dp)
                        ) {
                        }
                        Card(
                            Modifier
                                .width((screenWidth / 2) - 20.dp)
                                .height(155.dp)
                                .padding(horizontal = 5.dp)
                        ) {
                        }
                        Card(
                            Modifier
                                .width((screenWidth / 2) - 20.dp)
                                .height(155.dp)
                                .padding(horizontal = 5.dp)
                        ) {
                        }
                        Card(
                            Modifier
                                .width((screenWidth / 2) - 20.dp)
                                .height(155.dp)
                                .padding(horizontal = 5.dp)
                        ) {
                        }
                        Card(
                            Modifier
                                .width((screenWidth / 2) - 20.dp)
                                .height(155.dp)
                                .padding(horizontal = 5.dp)
                        ) {
                        }
                    }

                }
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Column(
                    Modifier
                        .width(screenWidth - 10.dp)
                        .height(screenHeight / 3)
                        .background(LightVioletBlue)
                ) {

                    Text(
                        text = "Ongoing Task"
                    )
                    Row() {
                        Text(
                            text = "End on"
                        )
                        Text(
                            text = "12/12/12"
                        )
                    }

                }
            }
        }
    }
}

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