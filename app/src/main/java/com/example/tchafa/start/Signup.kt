package com.example.tchafa.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.R
import com.example.tchafa.ui.theme.BackgroundGreen
import com.example.tchafa.ui.theme.ComponentGreen
import com.example.tchafa.ui.theme.LightBlack
import com.example.tchafa.ui.theme.White

@Composable
fun SignupScreen()
{
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp


    Column(
        Modifier
            .fillMaxSize()
            .background(BackgroundGreen), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.signup), contentDescription = "Sign up illustration",
            modifier = Modifier.padding(top = 20.dp)
                .size(250.dp)
            )
        Text(text = "CREATE YOUR ACCOUNT", style = typography.subtitle1,modifier = Modifier.padding(bottom = 35.dp))

        Column (
            Modifier
                .width(screenWidth + 3.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(White)
                .height((screenHeight / 2) + 20.dp)
                .padding(top = 25.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            var firstname by remember {
                mutableStateOf("")
            }

            var lastname by remember {
                mutableStateOf("")
            }

            var email by remember {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }

            OutlinedTextField(
                value = firstname,
                onValueChange = { newText ->
                    firstname = newText
                },
                leadingIcon ={
                    Image(
                    painter = painterResource(id = R.drawable.person), contentDescription = "PassWord")
                },
                shape = RoundedCornerShape(30.dp),
                modifier =  Modifier.height(60.dp),

                label = { Text(text = "FirstName", color = LightBlack) },
                textStyle = TextStyle(color = Color.Black, fontSize = 22.sp, fontFamily = FontFamily.Monospace),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = ComponentGreen,
                    unfocusedBorderColor = LightBlack
                )
            )

            OutlinedTextField(
                value = lastname,
                onValueChange = { newText ->
                    lastname = newText
                },
                leadingIcon ={androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.person), contentDescription = "PassWord")},
                shape = RoundedCornerShape(30.dp),
                modifier =  Modifier.height(60.dp),

                label = { Text(text = "LastName", color = LightBlack) },
                textStyle = TextStyle(color = Color.Black, fontSize = 22.sp, fontFamily = FontFamily.Monospace),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = ComponentGreen,
                    unfocusedBorderColor = LightBlack)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { newText ->
                    email = newText
                },
                modifier =  Modifier.height(60.dp),
                leadingIcon ={androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.email), contentDescription = "Email")},
                shape = RoundedCornerShape(30.dp),
                label = { Text(text = "Email", color = LightBlack) },
                textStyle = TextStyle(color = Color.Black, fontSize = 22.sp, fontFamily = FontFamily.Monospace),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = ComponentGreen,
                    unfocusedBorderColor = LightBlack)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { newText ->
                    password = newText
                },
                leadingIcon ={androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.password), contentDescription = "PassWord")},
                shape = RoundedCornerShape(30.dp),
                modifier =  Modifier.height(60.dp),

                label = { Text(text = "Password", color = LightBlack) },
                textStyle = TextStyle(color = Color.Black, fontSize = 22.sp, fontFamily = FontFamily.Monospace),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = ComponentGreen,
                    unfocusedBorderColor = LightBlack)
            )

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = ComponentGreen),
                shape = RoundedCornerShape(35),
                modifier = Modifier.width(125.dp).padding(top = 10.dp)
            ) {
                Text(text = "SignUp", color = Color.Black)
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = White),
                elevation = null
            ) {
                Text(text = "Already have an account",color = Color.Black, fontSize = 12.sp, fontFamily = FontFamily.Monospace,
                    modifier = Modifier.padding(bottom = 15.dp))
            }
        }
    }
}
