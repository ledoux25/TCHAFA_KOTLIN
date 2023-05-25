package com.example.tchafa.bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tchafa.R
import com.example.tchafa.navigation.Screen
import com.example.tchafa.ui.theme.BackgroundGray
import com.example.tchafa.ui.theme.ComponentBlue
import com.example.tchafa.ui.theme.TextBlue

@Composable
fun bottomNav(navController: NavController){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
        , horizontalArrangement = Arrangement.SpaceBetween)
    {
        Column(Modifier.clickable { navController.navigate(Screen.HomeScreen.route)}, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.home_blue), contentDescription ="home",modifier = Modifier.size(25.dp) )
            Text(text = "Home", color = TextBlue)
        }
        Column(Modifier.clickable { navController.navigate(Screen.OLPublications.route)},  horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.publication_blue), contentDescription ="home",modifier = Modifier.size(25.dp) )
            Text(text = "Publication", color = TextBlue)
        }
        Column(Modifier.clickable {  }) {
            Image(painter = painterResource(id = R.drawable.search), contentDescription ="home",modifier = Modifier.size(25.dp) )
            Text(text = "Search", color = TextBlue)
        }
        Column(Modifier.clickable { navController.navigate(Screen.HomeScreen.route)},  horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.candidature_blue), contentDescription ="home",modifier = Modifier.size(25.dp) )
            Text(text = "Candidates", color = TextBlue)
        }
        Column(Modifier.clickable { navController.navigate(Screen.ProfileScreen.route) }, horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "notif_button",
                tint = ComponentBlue,
                modifier = Modifier.size(25.dp)
            )
            Text(text = "Profile", color = TextBlue)
        }
    }
}