package com.example.tchafa.navigation

import com.example.tchafa.R

sealed class sidebarNav(
    val route : String,
    val icon : Int,
    val title : String
){
    object Needs : sidebarNav("myNeeds", R.drawable.need, "Needs")
    object Pubs: sidebarNav("myPubs", R.drawable.publication, "Publications")
    object Recoms : sidebarNav("myRecoms", R.drawable.recom, "Recommendations")
    object Candis: sidebarNav("myCandis", R.drawable.candi, "Candidatures")
}
