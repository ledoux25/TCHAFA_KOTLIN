package com.example.tchafa.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.navigation.Screen
import com.example.tchafa.ui.theme.Background
import com.example.tchafa.ui.theme.*

@Composable
fun ProfileScreen(navController: NavController){
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Column(
        Modifier
            .background(Background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .height((screenHeight / 6))
                .background(Background),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(R.drawable.back_arrow),
                contentDescription = "back",
                modifier = Modifier
                    .padding(start = 7.dp)
                    .size(50.dp)
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Proffesional Profile",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Medium,
                    color = White,
                    fontFamily = FontFamily.Monospace
                )
            }
        }
        Column(
            Modifier

                .height(screenHeight / 1.2f)
                .clip(shape = RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp))
                .background(LightGray)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Column (
                Modifier
                    .width(screenWidth / 1.1f)
                    .height(screenHeight / 3.8f)
                    .padding(vertical = 20.dp, horizontal = 15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .shadow(elevation = 3.dp)
                    .background(White)
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Sanguo Joseph Ledoux", fontSize = 30.sp )
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 11.dp, top = 3.dp)) {
                    Text(text = "Birthday : ", fontSize = 22.sp)
                    Text(text = " 25/02/2006", fontSize = 22.sp)
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 11.dp, top = 4.dp)) {
                    Text(text = "Average :", fontSize = 22.sp )
                    Text(text = " 3/5", fontSize = 22.sp )
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 11.dp, top = 3.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,) {
                    Row(Modifier.padding(top =4.dp)) {
                        Text(text = "Sex : ", fontSize = 22.sp )
                        Text(text = " M", fontSize = 22.sp)
                    }
                       Button(
                           onClick = {navController.navigate(Screen.ProfileForm.route)},
                           colors = ButtonDefaults.buttonColors(backgroundColor = ComponentBlue),
                           shape = RoundedCornerShape(35),
                           modifier = Modifier
                               .width(100.dp)
                               .height(145.dp)
                       ) {
                           Text(
                               text = " Modify",
                               fontSize = 20.sp,
                               fontFamily = FontFamily.Monospace,
                           )
                   }
                }
            }
            
            Row(
                Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                Card(
                    Modifier
                        .width(screenWidth / 1.5f)
                        .height(155.dp)
                        .padding(horizontal = 8.dp,)
                ) {
                }
                Card(
                    Modifier
                        .width(screenWidth / 1.5f)
                        .height(155.dp)
                        .padding(horizontal = 8.dp,)
                ) {
                }
                Column(
                    Modifier
                        .width(screenWidth / 1.5f)
                        .height(155.dp)
                        .padding(horizontal = 8.dp,)
                ) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Text(text = "Domestique")
                    }
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Text(text = "Spécialiter")
                    }
                    Column() {
                        
                    }
                }
            }
        }
    }
}