package com.example.tchafa

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.tchafa.components.rememberImeState
import com.example.tchafa.start.LoginScreen
import androidx.navigation.compose.rememberNavController
import com.example.tchafa.start.SignupScreen
import com.example.tchafa.ui.theme.TCHAFATheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< HEAD


=======
>>>>>>> fee0aad9183c4da434772c0bf6314c38bdd1c3cb
        setContent {
            TCHAFATheme {
                val imeState = rememberImeState()
                val scrollState = rememberScrollState()

                LaunchedEffect(key1 = imeState.value){
                    if(imeState.value){
                        scrollState.scrollTo(scrollState.maxValue)
                    }
                }
<<<<<<< HEAD
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                    color = MaterialTheme.colors.background
                ) {
                   // LoginScreen()

=======
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
        setContent {
            TCHAFATheme {
                val imeState = rememberImeState()
                val scrollState = rememberScrollState()

                LaunchedEffect(key1 = imeState.value){
                    if(imeState.value){
                        scrollState.scrollTo(scrollState.maxValue)
                    }
>>>>>>> fee0aad9183c4da434772c0bf6314c38bdd1c3cb
                }
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
            SplachScreenPreview()
        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TCHAFATheme {
<<<<<<< HEAD
        //LoginScreen()

=======
>>>>>>> fee0aad9183c4da434772c0bf6314c38bdd1c3cb
    }
}