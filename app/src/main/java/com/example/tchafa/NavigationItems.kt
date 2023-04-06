package com.example.tchafa

sealed class NavigationItems(var route: String, var icon: Int, var title: String){
    object Home : NavigationItems("home", R.drawable.ic_home, "Home")
    object Search : NavigationItems("search", R.drawable.ic_search, "Search")
    object Add: NavigationItems("add", R.drawable.ic_add, "Add")
    object Notifications : NavigationItems("notifications", R.drawable.ic_notification, "Notifications")
    object Profile : NavigationItems("profile", R.drawable.ic_profile, "Profile")
}
