package com.example.tchafa

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.ui.theme.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NeedDetail() {




    Scaffold(
        /*box principal d'en-tete de couleur bordeaux*/
        Modifier.fillMaxSize(),
        backgroundColor = Bordeaux,
    ) {
        Text(
            text = "Need",
            fontSize = 40.sp,
            color = Color.White,
            fontFamily = SecularOne,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(150.dp,40.dp)
        )
        Image(
            painter = painterResource(R.drawable.back),
            contentDescription = null,
            modifier = Modifier
                .size(45.dp)
                .padding(10.dp, 10.dp)
        )

        /*deuxieme box grise clair portant les box de detail de besoin */

        Box(
            Modifier
                .fillMaxWidth()
                .padding(top = 124.dp)
                .background(
                    color = Silver,
                )
                .size(420.dp, 720.dp)


        ){

                    Text(
                        text = "See all",
                        fontSize = 20.sp,
                        fontFamily = SecularOne,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding( 20.dp, 20.dp)

                    )


            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {

                /*premiere box de details de besoin */
                /*debut de le premiere  ligne de la colonne*/
               Box(
                    Modifier

                        .padding(18.dp, 90.dp)
                        .background(
                            color = Color.White, RoundedCornerShape(
                                topStart = 25.dp,
                                topEnd = 25.dp,
                                bottomStart = 25.dp,
                                bottomEnd = 25.dp
                            )
                        )
                        .size(400.dp, 240.dp),
                    contentAlignment = Alignment.Center

                ) {
                   Column(
                       verticalArrangement = Arrangement.spacedBy(0.dp),
                       modifier = Modifier.fillMaxSize()
                   ) {

                       Row(
                           horizontalArrangement = Arrangement.spacedBy(22.dp),
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(35.dp, 10.dp)
                       ) {

                           /* box du nom du besoin  */

                           Box(
                               Modifier

                                   .background(
                                       color = Silver2, RoundedCornerShape(
                                           topStart = 25.dp,
                                           topEnd = 25.dp,
                                           bottomStart = 25.dp,
                                           bottomEnd = 25.dp
                                       )
                                   )
                                   .size(140.dp, 48.dp)
                           ) {
                               Text(
                                   text = "Domestique",
                                   fontSize = 16.sp,
                                   fontFamily = Segoeui,
                                   textAlign = TextAlign.Center,
                                   fontWeight = FontWeight.Normal,
                                   style = MaterialTheme.typography.h4,
                                   modifier = Modifier.padding(18.dp, 12.dp)
                               )
                           }

                           /* box du nom de la ville  */

                           Box(
                               Modifier
                                   .background(
                                       color = Silver2, RoundedCornerShape(
                                           topStart = 25.dp,
                                           topEnd = 25.dp,
                                           bottomStart = 25.dp,
                                           bottomEnd = 25.dp
                                       )
                                   )
                                   .size(140.dp, 48.dp),
                               contentAlignment = Alignment.Center
                           ) {
                               Text(
                                   text = "Douala",
                                   fontSize = 16.sp,
                                   fontFamily = Segoeui,
                                   textAlign = TextAlign.Center,
                                   fontWeight = FontWeight.Normal,
                                   style = MaterialTheme.typography.h6,
                                   modifier = Modifier.padding(18.dp, 12.dp)
                               )
                           }

                       }/* on sort de la ligne  */
                       /*fin de la premiere ligne de la colonne */


                       /* box du detail litteral */
                       /*debut de la deuxieme ligne de la colonne */
                       Row(
                           horizontalArrangement = Arrangement.spacedBy(22.dp),
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(25.dp, 10.dp)
                       ) {
                       Box(
                           modifier = Modifier
                               .background(
                                   color = Silver2, RoundedCornerShape(
                                       topStart = 12.dp,
                                       topEnd = 12.dp,
                                       bottomStart = 12.dp,
                                       bottomEnd = 12.dp
                                   )
                               )
                               .padding(20.dp, 15.dp)
                               .size(350.dp, 60.dp),
                           contentAlignment = Alignment.Center
                       ) {
                           Text(
                               text = "Besoin ",
                               fontSize = 16.sp,
                               fontFamily = Segoeui,
                               fontWeight = FontWeight.Normal,
                               style = MaterialTheme.typography.h6,
                               modifier = Modifier.padding(25.dp, 15.dp)
                           )
                       }
                   }
                       /*fin de la deuxieme ligne de la colonne */


                       Row(
                           horizontalArrangement = Arrangement.spacedBy(15.dp),
                           modifier = Modifier.fillMaxWidth()
                               .padding(40.dp, 10.dp)
                       ) {
                           Button(onClick = { /* Action du premier bouton */ },
                                   modifier = Modifier
                               .background(
                                   color = Blue, RoundedCornerShape(
                                       topStart = 25.dp,
                                       topEnd = 25.dp,
                                       bottomStart = 25.dp,
                                       bottomEnd = 25.dp
                                   ))
                           ) {

                               Text("modify")
                           }

                           Button( onClick = { /* Action à exécuter lors du clic */ },
                               modifier = Modifier
                                   .background(
                                       color = Pink, RoundedCornerShape(
                                       topStart = 25.dp,
                                       topEnd = 25.dp,
                                       bottomStart = 25.dp,
                                       bottomEnd = 25.dp
                                   ))

                           ) {
                               Text("delete")
                           }

                           Button(onClick = { /* Action du troisième bouton */ },
                               modifier = Modifier
                                   .background(
                                       color = Bordeaux, RoundedCornerShape(
                                           topStart = 25.dp,
                                           topEnd = 25.dp,
                                           bottomStart = 25.dp,
                                           bottomEnd = 25.dp
                                       ))
                               ) {
                               Text("publish")
                           }
                       }

                   }

               }

                /*Premiere grande box de la colonne*/

                Box(
                    Modifier

                        .padding(18.dp, 90.dp)
                        .background(
                            color = Color.White, RoundedCornerShape(
                                topStart = 25.dp,
                                topEnd = 25.dp,
                                bottomStart = 25.dp,
                                bottomEnd = 25.dp
                            )
                        )
                        .size(400.dp, 220.dp),
                    contentAlignment = Alignment.Center

                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(0.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(22.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(35.dp, 10.dp)
                        ) {

                            /* box du nom du besoin  */

                            Box(
                                Modifier

                                    .background(
                                        color = Silver2, RoundedCornerShape(
                                            topStart = 25.dp,
                                            topEnd = 25.dp,
                                            bottomStart = 25.dp,
                                            bottomEnd = 25.dp
                                        )
                                    )
                                    .size(140.dp, 48.dp)
                            ) {
                                Text(
                                    text = "technique",
                                    fontSize = 16.sp,
                                    fontFamily = Segoeui,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Normal,
                                    style = MaterialTheme.typography.h4,
                                    modifier = Modifier.padding(18.dp, 12.dp)
                                )
                            }

                            /* box du nom de la ville  */

                            Box(
                                Modifier
                                    .background(
                                        color = Silver2, RoundedCornerShape(
                                            topStart = 25.dp,
                                            topEnd = 25.dp,
                                            bottomStart = 25.dp,
                                            bottomEnd = 25.dp
                                        )
                                    )
                                    .size(140.dp, 48.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Douala",
                                    fontSize = 16.sp,
                                    fontFamily = Segoeui,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Normal,
                                    style = MaterialTheme.typography.h6,
                                    modifier = Modifier.padding(18.dp, 12.dp)
                                )
                            }

                        }/* on sort de la ligne  */
                        /*fin de la premiere ligne de la colonne */


                        /* box du detail litteral */
                        /*debut de la deuxieme ligne de la colonne */
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(22.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(25.dp, 10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = Silver2, RoundedCornerShape(
                                            topStart = 12.dp,
                                            topEnd = 12.dp,
                                            bottomStart = 12.dp,
                                            bottomEnd = 12.dp
                                        )
                                    )
                                    .padding(20.dp, 15.dp)
                                    .size(350.dp, 60.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Besoin ",
                                    fontSize = 16.sp,
                                    fontFamily = Segoeui,
                                    fontWeight = FontWeight.Normal,
                                    style = MaterialTheme.typography.h6,
                                    modifier = Modifier.padding(25.dp, 15.dp)
                                )
                            }
                        }
                        /*fin de la deuxieme ligne de la colonne */


                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.dp),
                            modifier = Modifier.fillMaxWidth()
                                .padding(40.dp, 10.dp)
                        ) {
                            Button(onClick = { /* Action du premier bouton */ },
                                modifier = Modifier
                                    .background(
                                        color = Blue, RoundedCornerShape(
                                            topStart = 25.dp,
                                            topEnd = 25.dp,
                                            bottomStart = 25.dp,
                                            bottomEnd = 25.dp
                                        ))
                            ) {

                                Text("modify")
                            }

                            Button( onClick = { /* Action à exécuter lors du clic */ },
                                modifier = Modifier
                                    .background(
                                        color = Pink, RoundedCornerShape(
                                            topStart = 25.dp,
                                            topEnd = 25.dp,
                                            bottomStart = 25.dp,
                                            bottomEnd = 25.dp
                                        ))

                            ) {
                                Text("delete")
                            }

                            Button(onClick = { /* Action du troisième bouton */ },
                                modifier = Modifier
                                    .background(
                                        color = Bordeaux, RoundedCornerShape(
                                            topStart = 25.dp,
                                            topEnd = 25.dp,
                                            bottomStart = 25.dp,
                                            bottomEnd = 25.dp
                                        ))
                            ) {
                                Text("publish")
                            }
                        }

                    }

                }

                }


            }

        }


    }



/*
@Preview(showBackground = true)
@Composable
fun preview()
{

}

@Composable
fun SignupScreen(
    //navController: NavController
) {
    //val imeState = rememberImeState()
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
    ) {
        /*LaunchedEffect(key1 = imeState.value) {
            if (imeState.value) {
                scrollState.scrollTo(scrollState.maxValue)
            }
        }*/
        val configuration = LocalConfiguration.current
        val screenHeight = configuration.screenHeightDp.dp
        val screenWidth = configuration.screenWidthDp.dp


        Column(
            Modifier
                .fillMaxSize(),
            //.background(Background),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.signup),
                contentDescription = "Sign up illustration",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .size(250.dp)
            )
            Text(
                text = "CREATE YOUR ACCOUNT",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(bottom = 35.dp)
            )

            Column(
                Modifier
                    .width(screenWidth + 3.dp)
                    .clip(shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                    .background(Color.White)
                    .height((screenHeight / 2) + 20.dp)
                    .padding(top = 25.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

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
                    value = email,
                    onValueChange = { newText ->
                        email = newText
                    },
                    modifier = Modifier.height(60.dp),
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.email),
                            contentDescription = "Email"
                        )
                    },
                    shape = RoundedCornerShape(15.dp),
                    label = { Text(text = "Email", color = Bordeaux) },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontFamily = FontFamily.Monospace
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = Color.Black
                    )
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { newText ->
                        password = newText
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.password),
                            contentDescription = "PassWord"
                        )
                    },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.height(60.dp),

                    label = { Text(text = "Password", color = Color.Black) },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontFamily = FontFamily.Monospace
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = Color.Black
                    )
                )

                OutlinedTextField(
                    value = lastname,
                    onValueChange = { newText ->
                        lastname = newText
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.password),
                            contentDescription = "ConfirmPassWord"
                        )
                    },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.height(60.dp),

                    label = { Text(text = "Confirm Password", color = Color.Black) },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontFamily = FontFamily.Monospace
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = Color.Black
                    )
                )

                Button(
                    onClick = {
                        /*if (password.isEmpty() || lastname.isEmpty() || email.isEmpty()) {
                            Toast.makeText(context, "Fill all the blank spaces", Toast.LENGTH_SHORT)
                        } else if (password.length < 6) {
                            Toast.makeText(
                                context,
                                "Password Should atleast have 6 characters",
                                Toast.LENGTH_SHORT
                            )
                        } else if (password != lastname) {
                            Toast.makeText(
                                context,
                                "Password Validation Failed",
                                Toast.LENGTH_SHORT
                            )
                        } else {
                            lateinit var auth: FirebaseAuth
                            auth = Firebase.auth

                            auth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(ContentValues.TAG, "createUserWithEmail:success")
                                        navController.navigate(route = Screen.Login.route)
                                        val user = auth.currentUser
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                                        Toast.makeText(
                                            context,
                                            "Authentication failed.",
                                            Toast.LENGTH_SHORT,
                                        ).show()
                                    }
                                }
                        }*/
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    shape = RoundedCornerShape(35),
                    modifier = Modifier
                        .width(125.dp)
                        .padding(top = 10.dp)
                ) {
                    Text(text = "SignUp", color = Color.Black)
                }

                Button(
                    onClick = { /* Action du troisième bouton */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    elevation = null
                ) {
                    Text(
                        text = " I Already Have An Account",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.padding(bottom = 15.dp)
                    )
                }
            }
        }
    }
}*/




