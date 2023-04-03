package com.example.tchafa.need

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.Screen
import com.example.tchafa.components.bottomBorder
import com.example.tchafa.ui.theme.*


@Composable
fun NeedDetailViews( navController: NavController){

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }
    var input3 by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGreen),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            text = "Need Detail",
            fontWeight = FontWeight.Medium,
            fontSize = 40.sp,
        )

        Column(
            Modifier
                .clip(shape = RoundedCornerShape(20.dp))
                .fillMaxWidth()
                .height((screenHeight / 2))
                .background(White)
                .padding(vertical = 15.dp, horizontal = 25.dp),
            verticalArrangement = Arrangement.SpaceAround
        
        ) {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
                    ){
                Text(
                    text = "Paiment par",
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                )
                TextField(
                    value = input1,
                    onValueChange = {
                        input1 = it
                    },
                    modifier = Modifier
                        .bottomBorder(1.dp, LightBlack)
                        .height(50.dp),
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp, fontFamily = FontFamily.Monospace),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = ComponentGreen,
                        unfocusedBorderColor = LightBlack
                    )
                )
            }
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Lieux de service",
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                )
                TextField(
                    value = input2,
                    onValueChange = {
                        input2 = it
                    },
                    modifier = Modifier
                        .bottomBorder(1.dp, LightBlack)
                        .height(50.dp),
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp, fontFamily = FontFamily.Monospace),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = ComponentGreen,
                        unfocusedBorderColor = LightBlack
                    )
                )
            }
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Secteur demander",
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,

                )
                TextField(
                    value = input3,
                    onValueChange = {
                        input3 = it
                    },
                    modifier = Modifier
                        .bottomBorder(1.dp, LightBlack)
                        .height(55.dp),
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp, fontFamily = FontFamily.Monospace),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = ComponentGreen,
                        unfocusedBorderColor = LightBlack
                    )
                )
            }





        }
        Button(
            onClick = {
                navController.navigate(route = Screen.NeedDetail.route)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = ComponentGreen),
            shape = RoundedCornerShape(35),
            modifier = Modifier.width(125.dp)
        ) {
            Text(text = "Publish", color = Color.Black)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    Surface(color = Color.White) {
    }
}

