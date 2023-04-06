package com.example.tchafa


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tchafa.components.rememberImeState
import androidx.compose.ui.unit.dp
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
                // A surface container using the 'background' color from the theme
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


@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home Screen",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }

}

@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Profile Screen",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }

}

@Composable
fun SearchScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Search Screen",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }

}

@Composable
fun AddScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add Screen",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }

}

@Composable
fun NotifScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Notif Screen",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }

}

@Composable
fun Navigation(navController: NavHostController){

    NavHost(navController, startDestination = NavigationItems.Home.route){

        composable(NavigationItems.Home.route){
            HomeScreen()
        }

        composable(NavigationItems.Search.route){
            SearchScreen()
        }

        composable(NavigationItems.Add.route){
            AddScreen()
        }
        composable(NavigationItems.Notifications.route){
            NotifScreen()
        }
        composable(NavigationItems.Profile.route){
            ProfileScreen()
        }

    }

}
