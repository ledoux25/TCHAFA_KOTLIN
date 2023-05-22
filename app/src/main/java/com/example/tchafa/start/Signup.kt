package com.example.tchafa.start

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.R
import com.example.tchafa.ui.theme.SecularOne


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {

                    Image(
                    painter = painterResource(id = R.drawable.blue_back),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable(onClick = { /* back */ })
                            .padding(26.dp, 12.dp)
                            .size(35.dp)
                )

        },
        content = {

            Text(
                    text = "Welcome to TCHAFA",
                    fontFamily = SecularOne,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(42.dp, 70.dp),
                    fontSize = 25.sp,
                    color = Color.Blue
                )

                Text(
                    text = "Sign up to begin",
                    fontFamily = SecularOne,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(42.dp, 110.dp),
                    fontSize = 20.sp,
                    color = Color.Blue
                )

                Text(
                    text = "Already have an account?",
                    fontFamily = SecularOne,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(42.dp, 150.dp),
                    fontSize = 14.sp
                )
            Text(
                text = "and continue your activities",
                fontFamily = SecularOne,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(42.dp, 180.dp),
                fontSize = 14.sp
            )


            Column(
                modifier = Modifier
                    .padding(35.dp, 270.dp),

                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {



                Column(
                    modifier = Modifier.fillMaxWidth()) {

                    Spacer(Modifier.height(16.dp))
                        Text(text = "Email",
                                modifier = Modifier
                                .fillMaxWidth()
                            .padding(horizontal = 16.dp))
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        )


                        Spacer(Modifier.height(19.dp))
                        Text(text = "Password",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp))
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            modifier = Modifier.fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        )


                    Spacer(Modifier.height(19.dp))
                    Button(
                        onClick = { /* Handle sign up button click */ },
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
                    ) {
                        Text(text = "Sign Up",
                            color = Color.White,
                            fontFamily = SecularOne,
                            fontSize = 18.sp)
                    }
                }

                }

        }
    )
}


/*Column(
modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
verticalArrangement = Arrangement.spacedBy(0.dp),
horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(
        text = "Welcome to TCHAFA",
        fontFamily = SecularOne,
        style = MaterialTheme.typography.h4,
        modifier = Modifier.padding(12.dp, 70.dp),
        fontSize = 25.sp,
        color = Color.Blue
    )

    Text(
        text = "Sign up to begin",
        fontFamily = SecularOne,
        style = MaterialTheme.typography.h4,
        fontSize = 18.sp,
        color = Color.Blue
    )

    Text(
        text = "Already have an account?" +
                "and continue your activities",
        fontFamily = SecularOne,
        style = MaterialTheme.typography.h4,
        modifier = Modifier.padding(34.dp, 70.dp),
        fontSize = 14.sp
    )
}*/


/*@Composable
fun SignupScreen() {

    fun encryptPassword(password: String): String {
        // TODO: Crypter le mot de passe
        return "***"
    }
    Scaffold(
        /*box principal d'en-tete de couleur bordeaux*/
        Modifier.fillMaxSize(),
        backgroundColor = Color.White,
        topBar = {
            ButtonWithImage(
                imageResId = R.drawable.back,
                onClick = { /* Action à effectuer lors du clic */ }
            )
        },
        content ={
            Text(
                text = "Welcome to TCHAFA",
                fontSize = 18.sp,
                color = Color.Blue,
                fontFamily = SecularOne,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(45.dp,70.dp)
            )

            Text(
                text = "Sign up to begin.",
                fontSize = 18.sp,
                color = Color.Blue,
                fontFamily = SecularOne,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(65.dp,100.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(42.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp, 250.dp)
            ){
                EmailEntry()// appel la fonction EmailEntry
                PasswordEntry(encryptPassword)// appel la fonction PasswordEntry en passant la fonction encryptPassword comme paramètre

                Button(onClick = { /* bouton sign Up */ },
                    modifier = Modifier
                        .background(
                            color = Blue, RoundedCornerShape(
                                topStart = 25.dp,
                                topEnd = 25.dp,
                                bottomStart = 25.dp,
                                bottomEnd = 25.dp
                            )
                        )
                        .size(100.dp,50.dp)
                ){

                    Text("Sign Up")
                }

            }
        }
    )
}

@Composable
fun PasswordEntry(encryptPassword: (String) -> String) {
    var password by remember { mutableStateOf("") }
    val encryptedPassword = remember(password) { encryptPassword(password) }

    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = "Password")
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* TODO: Mettre à jour le mot de passe crypté */ }) {
                Text(text = "Crypter le mot de passe")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Mot de passe crypté: $encryptedPassword")
        }
    }
}





@Composable
fun ButtonWithImage(imageResId: Int, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .clip(MaterialTheme.shapes.medium)
            .clickable(onClick = onClick)
    )
}




@Composable
fun EmailEntry() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = "Email")
            OutlinedTextField(
                value = "",
                onValueChange = { /* TODO: Mettre à jour la valeur du champ */ },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}*/


/*@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignupScreen() {

    fun encryptPassword(password: String): String {
        // TODO: Crypter le mot de passe
        return "***"
    }
    Scaffold(
        /*box principal d'en-tete de couleur bordeaux*/
        Modifier.fillMaxSize(),
        backgroundColor = Color.White,
    ){


            ButtonWithImage(
                imageResId = R.drawable.blue_back,
                onClick = { /* Action à effectuer lors du clic */ }
            )

        Text(
            text = "Welcome to TCHAFA",
            fontSize = 18.sp,
            color = Color.Blue,
            fontFamily = SecularOne,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(45.dp,70.dp)
        )

        Text(
            text = "Sign up to begin.",
            fontSize = 18.sp,
            color = Color.Blue,
            fontFamily = SecularOne,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(65.dp,100.dp)
        )

    }

    Column(
        verticalArrangement = Arrangement.spacedBy(42.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp, 250.dp)
    ){
        Card(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
            elevation = 0.dp
        ) {
            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = "Email")
                OutlinedTextField(
                    value = "",
                    onValueChange = { /* TODO: Mettre à jour la valeur du champ */ },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
            elevation = 0.dp
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Password")
                OutlinedTextField(
                    value = "",
                    onValueChange = { /* TODO: Mettre à jour la valeur du champ */ },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Button(onClick = { /* bouton sign Up */ },
            modifier = Modifier
                .background(
                    color = Blue, RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp,
                        bottomStart = 25.dp,
                        bottomEnd = 25.dp
                    )
                )
                .size(100.dp,50.dp)
        ){

            Text("Sign Up")
        }

    }
    @Composable
    fun PasswordEntry() {
        var password by remember { mutableStateOf("") }
        val encryptedPassword = remember(password) { encryptPassword(password) }

        Card(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(text = "Password")
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { /* TODO: Mettre à jour le mot de passe crypté */ }) {
                    Text(text = "Crypter le mot de passe")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Mot de passe crypté: $encryptedPassword")
            }
        }
    }


}


@Composable
fun ButtonWithImage(imageResId: Int, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .clip(MaterialTheme.shapes.medium)
            .clickable(onClick = onClick)
    )
}




@Composable
fun EmailEntry() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = "Email")
            OutlinedTextField(
                value = "",
                onValueChange = { /* TODO: Mettre à jour la valeur du champ */ },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}*/



/*omposable
fun SignupScreen() {
    fun encryptPassword(password: String): String {
        // TODO: Crypter le mot de passe
        return "***"
    }

    Scaffold(
        /*box principal d'en-tete de couleur bordeaux*/
        Modifier.fillMaxSize(),
        backgroundColor = Color.White,
        topBar = {
            ButtonWithImage(
                imageResId = R.drawable.back,
                onClick = { /* Action à effectuer lors du clic */ }
            )
        },
        content = {
            Column(
                verticalArrangement = Arrangement.spacedBy(42.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp, 250.dp)
            ) {
                EmailEntry() // appel la fonction EmailEntry
                PasswordEntry(encryptPassword) // appel la fonction PasswordEntry en passant la fonction encryptPassword comme paramètre

                Button(
                    onClick = { /* bouton sign Up */ },
                    modifier = Modifier
                        .background(
                            color = Blue, RoundedCornerShape(
                                topStart = 25.dp,
                                topEnd = 25.dp,
                                bottomStart = 25.dp,
                                bottomEnd = 25.dp
                            )
                        )
                        .size(100.dp, 50.dp)
                ) {
                    Text("Sign Up")
                }
            }
        }
    )
}



@Composable
fun EmailEntry() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = "Email")
            OutlinedTextField(
                value = "",
                onValueChange = { /* TODO: Mettre à jour la valeur du champ */ },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}*/


