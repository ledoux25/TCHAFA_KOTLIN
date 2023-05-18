package com.example.tchafa.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.tchafa.ui.theme.Background

@Composable
fun resetPassword(navController: NavController){
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)) {
        Text(text = "Test Nav" )
    }
}