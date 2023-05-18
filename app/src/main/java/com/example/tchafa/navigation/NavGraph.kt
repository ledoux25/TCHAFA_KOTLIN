package com.example.tchafa.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tchafa.homescreen.homeScreen
import com.example.tchafa.need.NeedDetailViews
import com.example.tchafa.need.NeedHomeScreen
import com.example.tchafa.need.NeedModifyViews
import com.example.tchafa.profile.ProfileForm
import com.example.tchafa.profile.ProfileScreen
import com.example.tchafa.recommendations.PublicationHome
import com.example.tchafa.recommendations.RecommendationHome
import com.example.tchafa.start.LoginScreen
import com.example.tchafa.start.SignupScreen
import com.example.tchafa.start.resetPassword
import com.example.tchafa.ui.theme.onBoarding.OnBoarding
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = Screen.OnBoarding.route)
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
            route = Screen.OnBoarding.route
        ){
            OnBoarding(navController = navController)
        }

        composable(
            route = NavigationItems.Search.route
        ){
            NeedHomeScreen(navController = navController)
        }

        composable(
            route = Screen.HomeScreen.route
        ){
            homeScreen(navController = navController)
        }
        composable(
            route = NavigationItems.Home.route
        ){
            homeScreen(navController = navController)
        }
        composable(
            route = NavigationItems.Profile.route
        ){
           ProfileScreen(navController = navController)
        }
        composable(
            route = NavigationItems.Add.route
        ){
            PublicationHome(navController = navController)
        }
        composable(
            route = Screen.ProfileForm.route
        ){
            ProfileForm(navController = navController)
        }
        composable(
            route = NavigationItems.Notifications.route
        ){
            RecommendationHome(navController = navController)
        }
        composable(
            route = Screen.PublicationHome.route
        ){
            PublicationHome(navController = navController)
        }
        composable(
            route = NavigationItems.Add.route
        ){
            PublicationHome(navController = navController)
        }

        composable(
            route = NavigationItems.Notifications.route
        ){
            RecommendationHome(navController = navController)
        }

        composable(
            route = Screen.NeedModifyView.route
        ){
            NeedModifyViews(navController = navController)
        }

    }
}