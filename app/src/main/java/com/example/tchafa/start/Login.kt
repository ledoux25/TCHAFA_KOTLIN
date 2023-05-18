package com.example.tchafa.start


import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.components.BottomNavigationBar
import com.example.tchafa.components.rememberImeState
import com.example.tchafa.navigation.Screen
import com.example.tchafa.ui.theme.*
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private var user: FirebaseUser? = null
public var Email :String? = "Sanguo"

@Composable

fun LoginScreen(
    navController: NavController
) {

    val configuration = LocalConfiguration.current
    val context = LocalContext.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    var showMessage by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    Surface(
        modifier = Modifier
            .verticalScroll(scrollState),
    ) {
        LaunchedEffect(key1 = imeState.value) {
            if (imeState.value) {
                scrollState.scrollTo(scrollState.maxValue)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Background),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { navController.navigate(route = Screen.SignUp.route) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = White),
                    shape = RoundedCornerShape(35),
                    modifier = Modifier
                        .width(125.dp)
                        .padding(20.dp)
                ) {
                    Text(text = "SignUp", color = Color.Black)
                }
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Welcome back on our app",
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 46.sp,
                    color = White,
                    modifier = Modifier.padding(20.dp)
                )
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Image(
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(screenHeight / 3)
                )
            }
            Column(
                Modifier
                    .clip(shape = RoundedCornerShape(20.dp,20.dp,0.dp,0.dp))
                    .background(White)
                    .fillMaxWidth()
                    .height(screenHeight - (screenHeight / 2) - 100.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .height(65.dp)
                        .width(screenWidth - 75.dp),
                    label = { Text(text = "Email", color = LightBlack) },
                    leadingIcon = {
                        androidx.compose.foundation.Image(
                            painter = painterResource(id = R.drawable.email),
                            contentDescription = "Email adrees"
                        )
                    },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontFamily = FontFamily.Monospace
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = ComponentBlue,
                        unfocusedBorderColor = LightBlack
                    )
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { newText ->
                        password = newText
                    },
                    modifier = Modifier
                        .height(65.dp)
                        .width(screenWidth - 75.dp),
                    leadingIcon = {
                        androidx.compose.foundation.Image(
                            painter = painterResource(id = R.drawable.password),
                            contentDescription = "PassWord"
                        )
                    },
                    shape = RoundedCornerShape(30.dp),
                    label = { Text(text = "Password", color = LightBlack) },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontFamily = FontFamily.Monospace
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = ComponentBlue,
                        unfocusedBorderColor = LightBlack
                    )
                )
                Button(
                    onClick = {
                        if (password.isEmpty() || email.isEmpty()) {
                            Toast.makeText(context, "Fill all the blank spaces", Toast.LENGTH_SHORT)
                        } else {
                            try {
                                val auth = Firebase.auth
                                Email = email
                                auth.signInWithEmailAndPassword(email, password)
                                    .addOnCompleteListener { task ->
                                        showMessage = if (task.isSuccessful) {
                                            Log.d(TAG, "signInWithEmail:success")
                                            navController.navigate(Screen.HomeScreen.route)
                                            false
                                        } else {
                                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                                            message = task.exception.toString()
                                            Toast.makeText(context,"Authentification failed",Toast.LENGTH_SHORT)
                                            true
                                        }
                                    }
                            } catch (e: Exception) {
                                println(e.message)
                                message = e.message.toString()
                                showMessage = true
                            }
                        }
                    },
                    shape = RoundedCornerShape(15),
                    modifier = Modifier.width(125.dp)
                ) {
                    Text(text = "Login", color = Color.Black)
                }
                Text(
                    text = "Reset password",
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier.padding(bottom = 15.dp)
                )
            }

        }
       // BottomNavigationBar(navController = navController)
    }
}
private fun login() {
    val providers = arrayListOf(
        AuthUI.IdpConfig.EmailBuilder().build()
    )
    val loginIntent = AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setAvailableProviders(providers)
        .build()
}




