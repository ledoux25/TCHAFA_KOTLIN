package com.example.tchafa.start

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.navigation.Screen
import com.example.tchafa.ui.theme.*

@Composable
fun LoginHome(navController: NavController)
{
    val configuration = LocalConfiguration.current
    val context = LocalContext.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    Column(
        Modifier
            .background(BackgroundBlack)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
            ) {
        Column(Modifier.height(screenHeight/1.5f)) {
            
        }
        Column(
            Modifier
                .width(screenWidth - 45.dp)
                .height(screenHeight / 3.5f)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(Color.White)
                .padding(18.dp)
                ){
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Your Part Time Job Is", color = TextBlue, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Text(text = "Waiting You", color = TextBlue, fontSize = 30.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Find interesting jobs offers from", color = TextBlack)
                Text(text = "local individuals", color = TextBlack)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Button(onClick = { navController.navigate(Screen.Login.route) },
                    modifier = Modifier.width(144.dp).padding(end = 20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = ComponentBlue
                    )) {
                    Text(text = "Login", color = White, fontWeight = FontWeight.Bold, fontSize=18.sp)
                }
                Button(
                    onClick = { navController.navigate(Screen.SignUp.route) },
                    modifier = Modifier.width(120.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = ComponentBlue
                    )

                ) {
                    Text(text = "SignUp", color = White, fontSize=18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}