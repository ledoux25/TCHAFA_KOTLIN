package com.example.tchafa.navigation

import com.example.tchafa.R

sealed class NavigationItems(var route: String, var icon: Int, var title: String){
    object Home : NavigationItems("home", R.drawable.ic_home, "Home")
    object Search : NavigationItems("search", R.drawable.need, "Search")
    object Add: NavigationItems("add", R.drawable.publication, "Add")
    object Notifications : NavigationItems("recommendation", R.drawable.recom, "Notifications")
    object Profile : NavigationItems("profile", R.drawable.ic_profile, "Profile")
}
