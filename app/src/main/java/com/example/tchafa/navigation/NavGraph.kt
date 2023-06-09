package com.example.tchafa.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tchafa.log.homeScreen
import com.example.tchafa.start.Login
import com.example.tchafa.need.NeedDetailViews
import com.example.tchafa.need.NeedDetails
import com.example.tchafa.need.NeedHomeScreen
import com.example.tchafa.need.NeedModifyViews
import com.example.tchafa.profile.ProfileForm
import com.example.tchafa.profile.ProfileScreen
import com.example.tchafa.publication.OLPublicationDetail
import com.example.tchafa.publication.OLPublications
import com.example.tchafa.publication.PublicationDetail
import com.example.tchafa.publication.publicationHome
import com.example.tchafa.recommendations.PublicationHome
import com.example.tchafa.recommendations.RecommendationHome
import com.example.tchafa.start.LoginHome
import com.example.tchafa.start.SignUpScreen
import com.example.tchafa.start.resetPassword
import com.example.tchafa.ui.theme.onBoarding.OnBoarding
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route)
    {
        composable(
            route = Screen.LoginHome.route
        ){
            LoginHome(navController = navController)
        }
        composable(
            route = Screen.HomeScreen.route
        ){
            homeScreen(navController = navController)
        }
        composable(
            route = Screen.Login.route
        ){
            Login(navController = navController)
        }
        composable(
            route = Screen.SignUp.route
        ){
            SignUpScreen(navController = navController)
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
            route = Screen.NeedHome.route
        ){
            NeedHomeScreen(navController = navController)
        }

        composable(
            route = Screen.ProfileScreen.route
        ){
            ProfileScreen(navController = navController)
        }

        composable(
            route = Screen.RecommendationHome.route
        ){
            RecommendationHome(navController = navController)
        }
        composable(
            route = Screen.publicationHome.route
        ){
            publicationHome(navController = navController)
        }

        composable(
            route = Screen.NeedModifyView.route
        ){
            NeedModifyViews(navController = navController)
        }

        composable(
            route = Screen.NeedDetails.route
        ){
            NeedDetails(navController = navController)
        }

        composable(
            route = Screen.PublicationDetail.route
        ){
            PublicationDetail(navController = navController)
        }

        composable(
            route = Screen.OLPublications.route
        ){
            OLPublications(navController = navController)
        }

        composable(
            route = Screen.OLPublicationsDetail.route
        ){
            OLPublicationDetail(navController = navController)
        }

        composable(
            route = Screen.ProfileForm.route
        ){
            ProfileForm(navController = navController)
        }

    }
}