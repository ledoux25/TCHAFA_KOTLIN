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
            .background(White)
            .fillMaxSize(),
    ){
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
        }
        Row(){
            Image(painter = painterResource(id = R.drawable.no_image), contentDescription ="no image", modifier = Modifier.size(30.dp) )
            Column() {
                Text(text = "Justin Nah", fontWeight = FontWeight.Medium , fontSize = 22.sp)
                Text(text = "jutinnah@gmail.com", fontSize = 19.sp)
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.width(65.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = ComponentBlue
                    )
                ) {
                    Text(text = "Edit Profile")
                }
            }
        }
        Column() {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Image(painter = painterResource(id = R.drawable.person), contentDescription = "yes")
                Text(text = "Personal Informations")
                Image(painter = painterResource(id = R.drawable.next_arrow), contentDescription = "yes")
            }
        }
    }
}