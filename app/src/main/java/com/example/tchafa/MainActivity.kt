package com.example.tchafa

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.tchafa.components.rememberImeState
import com.example.tchafa.start.LoginScreen
import androidx.navigation.compose.rememberNavController
import com.example.tchafa.start.SignupScreen
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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
fun mainView()
{
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .fillMaxSize()
            .padding(8.dp),
        color = Color.Gray
    ) {

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    Scaffold(
        topBar = { myTopBar()},
        content = { myContent()}
    )
}

@Composable
fun myContent()
{
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Red)
    ) {
        items((0..30).toList()){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                elevation = 23.dp
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                        Text(text = "item $it", fontSize = 15.sp)
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}


@Composable
fun myTopBar()
{
    TopAppBar(
        title = { Text(text = "Scaffold")},
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    )
}
