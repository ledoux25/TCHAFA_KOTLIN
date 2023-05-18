package com.example.tchafa.log

import android.annotation.SuppressLint
import androidx.compose.foundation.background
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
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.ui.theme.White
import com.example.tchafa.ui.theme.primaryBlue
import com.example.tchafa.ui.theme.secondBlue


// this code has been done by Michel Toko

@Composable
fun TopBar(screenWidth: Int, screenHeight: Int)
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
                  contentDescription = "menu_button"
              )

          }

          IconButton(
              onClick = {}
          ) {
              Icon(
                  imageVector = Icons.Filled.Notifications,
                  contentDescription = "notif_button"
              )

          }

      }
    }
}

@Composable
fun Content(screenWidth: Int, screenHeight: Int)
{
    val blueCardheight = screenHeight / 5

    Column (
        modifier = Modifier.fillMaxWidth()
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
                .size(width = 350.dp, height = blueCardheight.dp)
                .background(color = secondBlue, RoundedCornerShape(26.dp))
            )
            {
                Row(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Box(modifier = Modifier
                        .size(width = 175.dp, height = blueCardheight.dp)
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Text(text = "Create your profile",
                                style = MaterialTheme.typography.h5,
                                color = Color.White
                            )

                            Text(text="un texte que je n'arrive pas ...", color = Color.White)


                        }
                    }
                    Box(modifier = Modifier
                        .size(width = 165.dp, height = blueCardheight.dp)
                        .padding(
                            top = (blueCardheight - (blueCardheight / 3) - 20).dp,
                            start = 20.dp,
                            end = 20.dp
                        )
                    )
                    {
                        Mybutton()
                    }
                }
            }

        }
        SearchBar()
        SomeLine("Popular sector")


        Spacer(modifier = Modifier.height(20.dp))

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
        Text(text = firstString, fontWeight = FontWeight.Bold)
        Text(text = "See all", style = MaterialTheme.typography.overline)
    }
}

@Composable
fun Mybutton()
{
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .size(width = 100.dp, height = 50.dp)
                .background(Color.White)
                .padding(0.dp),
            shape = MaterialTheme.shapes.medium,
            )
        {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text="GO ON",
                color = secondBlue,
                style = MaterialTheme.typography.h6,
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
        Text(text = title, fontSize = 18.sp)
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
            modifier = Modifier.size(width = width.dp, height = 50.dp)
                .background(color = primaryBlue, RoundedCornerShape(6.dp))
        ) {

        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun homeScreen()
{
    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp
    val screenHeight = config.screenHeightDp

    Item(screenWidth = screenWidth)

    /*Scaffold(
        topBar = { TopBar(screenWidth, screenHeight) },
        content = { Content(screenWidth, screenHeight) }
    )*/
}




@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){
    homeScreen()
}