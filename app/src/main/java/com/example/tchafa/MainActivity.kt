package com.example.tchafa


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tchafa.navigation.SetupNavGraph
import com.example.tchafa.ui.theme.TCHAFATheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var auth: FirebaseAuth

        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContent {
            TCHAFATheme {
                    navController = rememberNavController()
                    SetupNavGraph(navController = navController)
                    // A surface container using the 'background' color from the theme
                /* A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BottomNavigationBar(

                    )
                }
>>>>>>> origin/CHIEMO*/
            }
        }
    }
}