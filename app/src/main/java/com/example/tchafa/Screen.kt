package com.example.tchafa

sealed class Screen(val route: String ) {

    object Login: Screen(route = "login_screen")
    object SignUp:Screen(route = "signup_screen")
    object NeedDetail:Screen(route = "need_detail_screen")

    object SplashScreen :Screen(route = "splash_screen")

    object Home : NavigationItems("home", R.drawable.ic_home, "Home")
    object Search : NavigationItems("search", R.drawable.ic_search, "Search")
    object Add: NavigationItems("add", R.drawable.ic_add, "Add")
    object Notifications : NavigationItems("notifications", R.drawable.ic_notification, "Notifications")
    object Profile : NavigationItems("profile", R.drawable.ic_profile, "Profile")
}