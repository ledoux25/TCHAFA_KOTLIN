package com.example.tchafa.log

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.ui.theme.primaryBlue
import com.example.tchafa.ui.theme.secondBlue


@Composable
fun LoginPage(){

    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false)  }
    val focusRequest: FocusRequester = remember { FocusRequester() }

    //Back button

    Column(modifier = Modifier.fillMaxSize()){



        Row(
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "back_button"
                )

            }
            Text(
                text = "LOGO",
                modifier = Modifier
                    .padding(end = 15.dp),
                fontSize = 20.sp
            )
        }

        Text(
            text = "Welcome to TCHAFA",
            modifier = Modifier
                .padding(15.dp),
            color = primaryBlue,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold
        )
        //2ème texte

        Text(
            text = "Login to continue",

            color = primaryBlue,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(start = 15.dp, top = 0.dp),
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier
                .padding(5.dp)
        )

        Text(
            text = "Already have an account?Login",
            modifier = Modifier
                .padding(12.dp, top = 5.dp),
            color = Color.Black,

            )
        //2ème texte

        Text(
            text = "and join the Tchafa's community",

            color = Color.Black,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(start = 15.dp)
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){


            Box(
                modifier = Modifier.fillMaxSize(),
                Alignment.CenterStart
            ){

            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    //.clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color.White)//Couleur
                    .padding(10.dp)
            ) {

                //ScrollableColumn()



                Spacer(
                    modifier = Modifier
                        .padding(40.dp)
                        .height(60.dp)
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange =  { emailValue.value = it},
                        label = { Text(text = "Email Address")},
                        placeholder = { Text(text = "Email Address")},
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                    )

                    Spacer(
                        modifier = Modifier
                            .padding(20.dp)
                            .height(5.dp)
                    )

                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange =  { passwordValue.value = it},
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility.value = !passwordVisibility.value
                            }) {
                                /*Image(
                                    painter = painterResource(id = R.drawable.eye),
                                    tint = if(passwordVisibility.value) primaryBlue else Color.Gray
                            )*/
                            }
                        },
                        label = { Text(text = "Password")},
                        placeholder = { Text(text = "Password")},
                        singleLine = true,
                        visualTransformation = if(passwordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    Spacer(modifier = Modifier.padding(25.dp))
                    Button(onClick = {  },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                            .background(secondBlue)) {
                        Text(
                            text = "Login",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }


                }
            }
        }

    }

    Box(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize()
    ){

    }



}

@Preview(showBackground = true)
@Composable
fun PreviewLoginPage(){
    LoginPage()
}