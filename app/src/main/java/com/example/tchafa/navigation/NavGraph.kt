package com.example.tchafa.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tchafa.SplachScreen
import com.example.tchafa.need.NeedDetailViews
import com.example.tchafa.start.LoginScreen
import com.example.tchafa.start.SignupScreen
import com.example.tchafa.start.resetPassword

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route )
    {
        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navController = navController)
        }
        composable(
            route = Screen.SignUp.route
        ){
            SignupScreen(navController = navController)
        }

        composable(
            route = Screen.NeedDetail.route
        ){
            NeedDetailViews(navController = navController)
        }

        composable(
            route = Screen.SplashScreen.route
        ){
            SplachScreen(navController = navController)
        }

        composable(
            route = NavigationItems.Home.route
        ){
            resetPassword(navController = navController)
        }

    }
}