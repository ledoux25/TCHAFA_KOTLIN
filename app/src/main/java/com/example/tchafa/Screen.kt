package com.example.tchafa

sealed class Screen(val route: String ) {

    object Login: Screen(route = "login_screen")
    object SignUp:Screen(route = "signup_screen")
    object NeedDetail:Screen(route = "need_detail_screen")

    object SplashScreen :Screen(route = "splash_screen")
}