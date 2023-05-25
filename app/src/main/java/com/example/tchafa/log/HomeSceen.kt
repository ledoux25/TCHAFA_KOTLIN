package com.example.tchafa.log

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.bar.bottomNav
import com.example.tchafa.navigation.Screen
import com.example.tchafa.ui.theme.*


// this code has been done by Michel Toko

@Composable
fun TopBar(screenWidth: Int, screenHeight: Int,navController: NavController)
{
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeight / 15).dp)
            .padding(horizontal = 0.dp),
        backgroundColor = Color.White
    ) {
      Row(
          modifier = Modifier
              .fillMaxSize()
              .padding(horizontal = 15.dp, vertical = 0.dp)
          ,
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
      )
      {
          IconButton(
              onClick = {}
          ) {
              Icon(
                  imageVector = Icons.Filled.Menu,
                  contentDescription = "menu_button",
                  tint = ComponentBlue
              )

          }

          IconButton(
              onClick = {navController.navigate(Screen.ProfileScreen.route)}
          ) {
              Icon(
                  imageVector = Icons.Filled.Person,
                  contentDescription = "notif_button",
                  tint =ComponentBlue,
              )

          }

      }
    }
}

@Composable
fun Content(screenWidth: Int, screenHeight: Int)
{
    var search by remember {
        mutableStateOf("")
    }
    val blueCardheight = screenHeight / 5

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height((blueCardheight + 30).dp)
                .padding(top = 25.dp)
            ,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier
                .size(width = 330.dp, height = blueCardheight.dp)
                .background(color = secondBlue, RoundedCornerShape(26.dp))
            )
            {
                Row(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Box(modifier = Modifier
                        .size(width = 155.dp, height = blueCardheight.dp)
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Text(text = "Create your profile",
                                style = MaterialTheme.typography.h5,
                                color = Color.White,
                                modifier = Modifier.padding(start = 10.dp,top = 5.dp)
                            )

                            Text(text="it only takes 1 minute", color = Color.White, fontSize = 12.sp,modifier = Modifier.padding(start = 10.dp,top = 5.dp))

                            Box(modifier = Modifier
                                .padding(
                                    start = 8.dp,
                                    end = 20.dp
                                )
                            )
                            {
                                Mybutton()
                            }
                        }
                    }

                }
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

            TextField(
                value = search,
                onValueChange = { newText -> search = newText },
                modifier = Modifier
                    .padding(top = 20.dp, end = 20.dp, start = 20.dp)
                    .height(46.dp)
                    .width(330.dp)
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
        SomeLine("Popular sector")


        Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                MyCard(title = "House keeper", screenWidth = screenWidth)
                MyCard(title = "Plumber", screenWidth = screenWidth)
                MyCard(title = "Chief", screenWidth = screenWidth)



                /*Button(onClick = { /* Do something */ }) {
                    Text("Button 1")
                }

                Button(onClick = { /* Do something */ }) {
                    Text("Button 1")
                }

                Button(onClick = { /* Do something */ }) {
                    Text("Button 3")
                }*/
            }

        SomeLine(firstString = "Recent publications")
    }



}

@Composable
fun SomeLine(firstString: String)
{
    Spacer(modifier = Modifier.height(20.dp))
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp), horizontalArrangement = Arrangement.SpaceBetween )
    {
        Text(text = firstString, fontWeight = FontWeight.Bold, color = Color.Black)
        Text(text = "See all", style = MaterialTheme.typography.overline, color = Color.Black)
    }
}

@Composable
fun Mybutton()
{
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .size(width = 100.dp, height = 35.dp)
                .clip(shape = RoundedCornerShape(8.dp)),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = White
            ),
            )
        {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text="GO ON !",
                color = secondBlue,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
        }


}

@Composable
fun SearchBar() {
    val text = remember { mutableStateOf("") }
    Spacer(modifier = Modifier.height(10.dp))
    TextField(
        value = text.value,
        onValueChange = { text.value = it },
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 16.dp),
        placeholder = { Text("Search") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = Color.Gray
            )
        }
    )
}

@Composable
fun MyCard(title: String, screenWidth: Int)
{
    val width = screenWidth / 5 + 30
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            modifier = Modifier
                .size(width = width.dp, height = width.dp)
                .background(color = secondBlue, RoundedCornerShape(6.dp))


        ) {

        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = title, fontSize = 18.sp, color = Color.Black)
    }
}

@Composable
fun Item(screenWidth: Int)
{
    val width: Int = screenWidth - 25
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(width = width.dp, height = 50.dp)
                .background(color = primaryBlue, RoundedCornerShape(6.dp))
        ) {

        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun homeScreen(navController: NavController)
{
    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp
    val screenHeight = config.screenHeightDp

    Item(screenWidth = screenWidth)

    Scaffold(
        topBar = { TopBar(screenWidth, screenHeight, navController) },
        content = { Content(screenWidth, screenHeight) },
        bottomBar = { bottomNav(navController = navController)}
    )
}