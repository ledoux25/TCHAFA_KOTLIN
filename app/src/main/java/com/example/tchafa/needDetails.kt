package com.example.tchafa

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.ui.theme.Indigo
import com.example.tchafa.ui.theme.LightGreen
import com.example.tchafa.ui.theme.SecularOne


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NeedDetails() {




    Scaffold(
        Modifier.fillMaxSize(),
        backgroundColor = Indigo,
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
                    ))
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
                    Image(
                        painter = painterResource(R.drawable.ic_profil_pic),
                        contentDescription = null,
                        modifier = Modifier.size(60.dp)
                    )

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



/*@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NeedDetails() {
    Scaffold(
        Modifier.fillMaxSize(),
        backgroundColor = Color.Green,
    ) {
        Column(Modifier.fillMaxSize()) {
            Text(
                text = "Tchafa",
                 fontSize = 24.sp,
                 fontFamily = SecularOne,
                 fontWeight = FontWeight.Normal,
                 style = MaterialTheme.typography.h6
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(top = 50.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_pic_profile),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                                .size(80.dp)
                                .clip(RoundedCornerShape(16.dp))
                        )
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Nom d'utilisateur",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Date",
                                fontSize = 16.sp,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Texte 1",
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                )
                Text(
                    text = "Texte 2",
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Texte 3",
                    modifier = Modifier.padding(16.dp)
                )
                Text(
                    text = "Bouton",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}*/




