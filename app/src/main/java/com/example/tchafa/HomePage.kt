package com.example.tchafa

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true)
fun HomePage(){

    var isExpanded by remember{
        mutableStateOf(false)
    }
    
    val widthAnim by animateDpAsState(targetValue = if(isExpanded) 200.dp else 50.dp)
    
    Scaffold {
        Box(){
            Column(
                Modifier.fillMaxSize(),
                Arrangement.Center,
                Alignment.CenterHorizontally
            ) {
                Text(text = "Home Page")
            }
            Column(
                Modifier
                    .fillMaxHeight()
                    .width(widthAnim)
                    .background(Color.Blue)
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.Start

            ) {
                Icon(
                    Icons.Default.Menu,
                    modifier = Modifier.clickable {
                        isExpanded = !isExpanded;
                    },
                    contentDescription = null, tint = Color.White
                )
                Spacer(modifier = Modifier.height(20.dp))
                DrawerItem(Icons.Default.Person, "Profile", isExpanded)
                DrawerItem(Icons.Default.Settings, "Setting", isExpanded)
                DrawerItem(Icons.Default.Info, "About", isExpanded)
                DrawerItem(Icons.Default.AccountBox, "Profile", isExpanded)
            }
        }
    }

}



@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DrawerItem(icon: ImageVector, title: String, expanded: Boolean){
    

    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon,
            contentDescription = null,
            tint = Color.White,)

        AnimatedContent(
            targetState = expanded,
            transitionSpec = {
                fadeIn(animationSpec = tween(150, 150)) with fadeOut(
                    tween(150)
                ) using SizeTransform{initialSize, targetSize ->
                    keyframes {
                        IntSize(targetSize.width, initialSize.height) at 150
                        durationMillis = 300
                    }
                }
            }
        ) {
                targetState ->
            if(targetState){

                Row(Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = title, color = Color.White)
                }
            }
        }

        /*Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Profile", color = Color.White)*/

    }
}