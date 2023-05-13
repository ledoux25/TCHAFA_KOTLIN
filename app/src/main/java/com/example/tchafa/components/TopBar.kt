package com.example.tchafa.components

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.ui.theme.Background
import com.example.tchafa.ui.theme.White

@Preview(showBackground = true)
@Composable
fun preview()
{
    TopBar()
}

@Composable
fun TopBar(){
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp


  TopAppBar(
      backgroundColor = Background,
  ) {
    Row(Modifier.width(screenWidth/2), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Rounded.Person,
            contentDescription = "",
            tint = colorResource(R.color.darker_gray),
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .clickable { }
        )
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxHeight()) {
            Text(
                text = "Your name",
                fontSize = 23.sp,
                color = White
            )
            Text(text = "your email", fontSize = 17.sp, color = White)
        }
    }
      Row(
          Modifier
              .width(screenWidth / 2)
              .padding(end = 15.dp), horizontalArrangement = Arrangement.End) {
          Icon(
              imageVector = Icons.Rounded.Notifications,
              contentDescription = "",
              tint = colorResource(R.color.white),
              modifier = Modifier
                  .width(35.dp)
                  .height(35.dp)
                  .padding(end = 10.dp)
                  .clickable { }
          )
          Icon(
              imageVector = Icons.Rounded.Menu,
              contentDescription = "",
              tint = colorResource(R.color.white),
              modifier = Modifier
                  .width(35.dp)
                  .height(35.dp)
                  .clickable { }
          )
      }
  }
}