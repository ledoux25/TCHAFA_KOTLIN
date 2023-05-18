package com.example.tchafa

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.navigation.Screen
import com.example.tchafa.ui.theme.*

@Composable
fun SplachScreen(navController: NavController) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background ),

        ) 
        {
            
            Text(
                text = "TCHAFA",
                fontFamily = FontFamily.Monospace,
                color= White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 15.dp, start =  10.dp)
            )

            Text(
                text = "SIMPLIFY THE WAY YOU WORK",
                color = White,
                fontSize = 33.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 55.dp)
                    .height(90.dp),
                textAlign = TextAlign.Right
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Image(
                    painter = painterResource(R.drawable.splash_screen),
                    contentDescription = "My Image",
                    modifier = Modifier
                        .size(290.dp)
                )
            }

            OnboardingScreen(navController = navController)
        }
    }



@Composable
fun OnboardingScreen(modifier: Modifier = Modifier, navController: NavController) {
    // TODO: This state should be hoisted
   // var shouldShowOnboarding by remember { mutableStateOf(true) }

    Row(

        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = {navController.navigate(Screen.Login.route)},
            colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue),
            shape = RoundedCornerShape(35),
            modifier = Modifier.width(125.dp).padding(top = 75.dp, bottom = 80.dp)
        ) {
            Text(text = "Begin", color = Color.Black)
        }

    }

}
