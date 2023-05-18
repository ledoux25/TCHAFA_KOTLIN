package com.example.tchafa.need

import android.content.ContentValues
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.navigation.Screen
import com.example.tchafa.ui.theme.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun NeedDetails(navController: NavController){
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {
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
                    .clickable { navController.popBackStack() })
            Image(painter = painterResource(R.drawable.modify),
                contentDescription = "Modify",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { navController.navigate(Screen.NeedModifyView.route) })
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
            Text(text = "UX Designer", color = Color.Black, fontSize = 28.sp, fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace, textDecoration = TextDecoration.Underline)
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
                Text(text = "Localisation",
                    color = TextBlack,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Monospace,)
                Text(text = "Douala",
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
                Text(text = "Domestique",
                    color = Color.Black,
                    fontSize = 28.sp,
                    fontFamily = FontFamily.Monospace,)
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
                value = "bg\ndzzdd",
                onValueChange = { /*TODO*/ },
                modifier = Modifier
                    .width(screenWidth-25.dp),
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
                onClick = {},
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
                onClick = {},
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