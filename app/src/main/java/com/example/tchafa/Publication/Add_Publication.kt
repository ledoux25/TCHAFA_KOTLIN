package com.example.tchafa.Publication

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.ui.theme.Bordeaux
import com.example.tchafa.ui.theme.SecularOne

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Add_Publication() {




    Scaffold(
        Modifier.fillMaxSize(),
        backgroundColor = Bordeaux,
    ) {
        Text(
            text = "Create Publication",
            fontSize = 29.sp,
            fontFamily = SecularOne,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(63.dp,40.dp)
        )

        Box(
            Modifier
                .fillMaxWidth()
                .padding(top = 124.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 45.dp,
                        topEnd = 45.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
                .size(420.dp, 720.dp)

        ){
            Column(Modifier.padding(16.dp))
            {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()

                        .padding(10.dp, 20.dp)
                ) {
                    /*Image(
                        painter = painterResource(R.drawable.ic_profil_pic),
                        contentDescription = null,
                        modifier = Modifier.size(60.dp)
                    )*/

                    Text(
                        text = "Tchafa",
                        fontSize = 20.sp,
                        fontFamily = SecularOne,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(end = 200.dp)

                    )

                    Text(
                        text = "Date",
                        color = Color.White,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

        }


    }
}