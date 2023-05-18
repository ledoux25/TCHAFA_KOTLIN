package com.example.tchafa.start

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.components.rememberImeState
import com.example.tchafa.navigation.Screen
import com.example.tchafa.ui.theme.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Preview(showBackground = true)
@Composable
fun preview()
{

}

@Composable
fun SignUpScreen(navController: NavController) {

    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val configuration = LocalConfiguration.current
    val context = LocalContext.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val passwordVisibility = remember { mutableStateOf(false) }
    var showMessage by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    val focusRequest: FocusRequester = remember { FocusRequester() }
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()


    Surface(
        modifier = Modifier
            .verticalScroll(scrollState).fillMaxSize(),
    ) {
        LaunchedEffect(key1 = imeState.value) {
            if (imeState.value) {
                scrollState.scrollTo(scrollState.maxValue)
            }
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .background(White)) {
            Row(
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {navController.popBackStack()}
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
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
            Column(
                Modifier
                    .height(screenHeight / 3)
                    .fillMaxWidth(), verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Welcome to TCHAFA",
                    modifier = Modifier
                        .padding(bottom = 3.dp, start = 20.dp),
                    color = primaryBlue,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
                //2ème texte

                Text(
                    text = "Sign up to begin.",
                    color = primaryBlue,
                    fontSize = 19.sp,
                    modifier = Modifier
                        .padding(start = 22.dp, top = 0.dp),
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier
                        .padding(5.dp)
                )
                Row() {
                    Text(
                        text = "Already have an account?",
                        modifier = Modifier
                            .padding(start = 22.dp, top = 5.dp),
                        color = Color.Black,

                        )
                    Text(
                        text = "Login",
                        modifier = Modifier
                            .padding(start = 2.dp, top = 5.dp)
                            .clickable { navController.navigate(Screen.Login.route) },
                        color = Color.Black,
                        textDecoration = TextDecoration.Underline
                    )
                }

                //2ème texte

                Text(
                    text = "and continue your activities",

                    color = Color.Black,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(start = 22.dp)
                )
            }


            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {


                Box(
                    modifier = Modifier.fillMaxSize(),
                    Alignment.CenterStart
                ) {

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

                    //ScrollableColumn()s
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 35.dp)){Text(text = "Email", color = Color.Black)}
                        OutlinedTextField(
                            value = emailValue.value,
                            onValueChange = { emailValue.value = it },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(49.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = LightBlack,
                                unfocusedBorderColor = LightBlack,
                                textColor = Color.Black
                            )
                        )

                        Spacer(
                            modifier = Modifier
                                .padding(5.dp)
                                .height(10.dp)
                        )
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 35.dp)){Text(text = "Password", color = Color.Black)}
                        OutlinedTextField(
                            value = passwordValue.value,
                            onValueChange = { passwordValue.value = it },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = LightBlack,
                                unfocusedBorderColor = LightBlack,
                                textColor = Color.Black
                            ),
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
                            singleLine = true,
                            visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                            else PasswordVisualTransformation(),
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(49.dp),
                        )

                        Spacer(modifier = Modifier
                            .padding(25.dp)
                            .height(15.dp))
                        Button(
                            onClick = {
                                if (passwordValue.value.isEmpty() || emailValue.value.isEmpty()) {
                                    Toast.makeText(context, "Fill all the blank spaces", Toast.LENGTH_LONG).show()
                                } else if (passwordValue.value.length < 6) {
                                    Toast.makeText(
                                        context,
                                        "Password Should atleast have 6 characters",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    lateinit var auth: FirebaseAuth
                                    auth = Firebase.auth

                                    auth.createUserWithEmailAndPassword(emailValue.toString(), passwordValue.toString())
                                        .addOnCompleteListener { task ->
                                            if (task.isSuccessful) {
                                                // Sign in success, update UI with the signed-in user's information
                                                Log.d(TAG, "createUserWithEmail:success")
                                                navController.navigate(route = Screen.Login.route)
                                                val user = auth.currentUser
                                            } else {
                                                // If sign in fails, display a message to the user.
                                                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                                                Toast.makeText(
                                                    context,
                                                    "Authentication failed.",
                                                    Toast.LENGTH_SHORT,
                                                ).show()
                                            }
                                        }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                                .clip(shape = RoundedCornerShape(5.dp)),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = ComponentBlue
                            )
                        ) {
                            Text(
                                text = "Sign Up",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = White
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
        ) {

        }
    }
}

