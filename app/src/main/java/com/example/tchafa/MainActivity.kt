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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tchafa.components.rememberImeState
import com.example.tchafa.start.LoginScreen
import com.example.tchafa.start.SignupScreen
import com.example.tchafa.ui.theme.TCHAFATheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TCHAFATheme {
                val imeState = rememberImeState()
                val scrollState = rememberScrollState()
                
                LaunchedEffect(key1 = imeState.value){
                    if(imeState.value){
                        scrollState.scrollTo(scrollState.maxValue)
                    }
                }
                    navController = rememberNavController()
                    SetupNavGraph(navController = navController)

            }
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
    }
}