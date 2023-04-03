package com.example.tchafa.start


import android.app.appsearch.AppSearchResult.RESULT_OK
import android.util.Log
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.Screen
import com.example.tchafa.components.rememberImeState
import com.example.tchafa.ui.theme.*
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

private var user: FirebaseUser? = null

@Composable
fun LoginScreen(
    navController: NavController
)
{
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = imeState.value){
        if(imeState.value){
            scrollState.scrollTo(scrollState.maxValue)
        }
    }

    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
   Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundGreen),
        verticalArrangement = Arrangement.SpaceBetween,
    ){
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Button(
                onClick = {navController.navigate(route = Screen.SignUp.route)},
                colors = ButtonDefaults.buttonColors(backgroundColor = White),
                shape = RoundedCornerShape(35),
                modifier = Modifier
                    .width(125.dp)
                    .padding(20.dp)
            ) {
                Text(text = "SignUp", color = Color.Black)
            }
        }
        Box(modifier = Modifier.fillMaxWidth() ){
            Text(text = "Welcome back on our app",
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
                modifier = Modifier.height(screenHeight / 3))
        }
        Column(
            Modifier
                .clip(shape = RoundedCornerShape(20.dp))
                .background(White)
                .fillMaxWidth()
                .height(screenHeight - (screenHeight / 2) - 100.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
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
                shape = RoundedCornerShape(30.dp),
                label = { Text(text = "Email", color = LightBlack) },
                leadingIcon = { androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.email),
                    contentDescription = "Email adrees"
                )},
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
                label = { Text(text = "Password", color = LightBlack) },
                textStyle = TextStyle(color = Color.Black, fontSize = 22.sp, fontFamily = FontFamily.Monospace),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = ComponentGreen,
                    unfocusedBorderColor = LightBlack)
            )
            Button(
                onClick = {
                          login()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = ComponentGreen),
                shape = RoundedCornerShape(35),
                modifier = Modifier.width(125.dp)
            ) {
                Text(text = "Login", color = Color.Black)
            }
            Text(text = "Reset password",color = Color.Black, fontSize = 12.sp, fontFamily = FontFamily.Monospace,
            modifier = Modifier.padding(bottom = 15.dp))
        }

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
    private val sign
private fun loginInResult(result: FirebaseAuthUIAuthenticationResult){
    val response = result.idpResponse
    if(result.resultCode == RESULT_OK){
         user = FirebaseAuth.getInstance().currentUser
    }else{
        Log.e("MainActivity.kt","Error logging in "+ response?.error?.errorCode)
    }
}

