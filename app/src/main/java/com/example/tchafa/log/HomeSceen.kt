package com.example.tchafa.log

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tchafa.ui.theme.primaryBlue
import com.example.tchafa.ui.theme.secondBlue

@Composable
fun TopBar()
{
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(horizontal = 0.dp)
            .background(color = Color.White)
    ) {
      Row(
          modifier = Modifier
              .fillMaxSize()
              .padding(horizontal = 15.dp, vertical = 0.dp)
          ,
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
      )
      {
        Box(modifier = Modifier
            .size(width = 30.dp, height = 30.dp)
            .background(color = primaryBlue))
        Box(modifier = Modifier
            .size(width = 30.dp, height = 30.dp)
            .background(color = primaryBlue))
      }
    }
}

@Composable
fun Content()
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .size(width = 350.dp, height = 120.dp)
            .background(color = secondBlue)
            .clip(RoundedCornerShape(56.dp))
        )
        {
            Column(
                modifier = Modifier
                    .width((350 / 2).dp)
                    .background(color = Color.Black)
            ) {
                    Text(text = "Je fais juste un foutu test")
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){
    Content()
    Scaffold(
        topBar = { TopBar() },
        content = { Content() }
    )


}