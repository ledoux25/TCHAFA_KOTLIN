package com.example.tchafa

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.ui.theme.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NeedDetail() {




    Scaffold(
        /*box principal d'en-tete de couleur bordeaux*/
        Modifier.fillMaxSize(),
        backgroundColor = Bordeaux,
    ) {
        Text(
            text = "Need",
            fontSize = 40.sp,
            color = Color.White,
            fontFamily = SecularOne,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(150.dp,40.dp)
        )
        Image(
            painter = painterResource(R.drawable.back),
            contentDescription = null,
            modifier = Modifier
                .size(45.dp)
                .padding(10.dp, 10.dp)
        )

        /*deuxieme box grise clair portant les box de detail de besoin */

        Box(
            Modifier
                .fillMaxWidth()
                .padding(top = 124.dp)
                .background(
                    color = Silver,
                )
                .size(420.dp, 720.dp)


        ){

                    Text(
                        text = "See all",
                        fontSize = 20.sp,
                        fontFamily = SecularOne,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding( 20.dp, 20.dp)

                    )


            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {

                /*premiere box de details de besoin */
                /*debut de le premiere  ligne de la colonne*/
               Box(
                    Modifier

                        .padding(18.dp, 90.dp)
                        .background(
                            color = Color.White, RoundedCornerShape(
                                topStart = 25.dp,
                                topEnd = 25.dp,
                                bottomStart = 25.dp,
                                bottomEnd = 25.dp
                            )
                        )
                        .size(400.dp, 240.dp),
                    contentAlignment = Alignment.Center

                ) {
                   Column(
                       verticalArrangement = Arrangement.spacedBy(0.dp),
                       modifier = Modifier.fillMaxSize()
                   ) {

                       Row(
                           horizontalArrangement = Arrangement.spacedBy(22.dp),
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(35.dp, 10.dp)
                       ) {

                           /* box du nom du besoin  */

                           Box(
                               Modifier

                                   .background(
                                       color = Silver2, RoundedCornerShape(
                                           topStart = 25.dp,
                                           topEnd = 25.dp,
                                           bottomStart = 25.dp,
                                           bottomEnd = 25.dp
                                       )
                                   )
                                   .size(140.dp, 48.dp)
                           ) {
                               Text(
                                   text = "Domestique",
                                   fontSize = 16.sp,
                                   fontFamily = Segoeui,
                                   textAlign = TextAlign.Center,
                                   fontWeight = FontWeight.Normal,
                                   style = MaterialTheme.typography.h4,
                                   modifier = Modifier.padding(18.dp, 12.dp)
                               )
                           }

                           /* box du nom de la ville  */

                           Box(
                               Modifier
                                   .background(
                                       color = Silver2, RoundedCornerShape(
                                           topStart = 25.dp,
                                           topEnd = 25.dp,
                                           bottomStart = 25.dp,
                                           bottomEnd = 25.dp
                                       )
                                   )
                                   .size(140.dp, 48.dp),
                               contentAlignment = Alignment.Center
                           ) {
                               Text(
                                   text = "Douala",
                                   fontSize = 16.sp,
                                   fontFamily = Segoeui,
                                   textAlign = TextAlign.Center,
                                   fontWeight = FontWeight.Normal,
                                   style = MaterialTheme.typography.h6,
                                   modifier = Modifier.padding(18.dp, 12.dp)
                               )
                           }

                       }/* on sort de la ligne  */
                       /*fin de la premiere ligne de la colonne */


                       /* box du detail litteral */
                       /*debut de la deuxieme ligne de la colonne */
                       Row(
                           horizontalArrangement = Arrangement.spacedBy(22.dp),
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(25.dp, 10.dp)
                       ) {
                       Box(
                           modifier = Modifier
                               .background(
                                   color = Silver2, RoundedCornerShape(
                                       topStart = 12.dp,
                                       topEnd = 12.dp,
                                       bottomStart = 12.dp,
                                       bottomEnd = 12.dp
                                   )
                               )
                               .padding(20.dp, 15.dp)
                               .size(350.dp, 60.dp),
                           contentAlignment = Alignment.Center
                       ) {
                           Text(
                               text = "Besoin ",
                               fontSize = 16.sp,
                               fontFamily = Segoeui,
                               fontWeight = FontWeight.Normal,
                               style = MaterialTheme.typography.h6,
                               modifier = Modifier.padding(25.dp, 15.dp)
                           )
                       }
                   }
                       /*fin de la deuxieme ligne de la colonne */


                       Row(
                           horizontalArrangement = Arrangement.spacedBy(15.dp),
                           modifier = Modifier.fillMaxWidth()
                               .padding(40.dp, 10.dp)
                       ) {
                           Button(onClick = { /* Action du premier bouton */ },
                                   modifier = Modifier
                               .background(
                                   color = Blue, RoundedCornerShape(
                                       topStart = 25.dp,
                                       topEnd = 25.dp,
                                       bottomStart = 25.dp,
                                       bottomEnd = 25.dp
                                   ))
                           ) {

                               Text("modify")
                           }

                           Button( onClick = { /* Action à exécuter lors du clic */ },
                               modifier = Modifier
                                   .background(
                                       color = Pink, RoundedCornerShape(
                                       topStart = 25.dp,
                                       topEnd = 25.dp,
                                       bottomStart = 25.dp,
                                       bottomEnd = 25.dp
                                   ))

                           ) {
                               Text("delete")
                           }

                           Button(onClick = { /* Action du troisième bouton */ },
                               modifier = Modifier
                                   .background(
                                       color = Bordeaux, RoundedCornerShape(
                                           topStart = 25.dp,
                                           topEnd = 25.dp,
                                           bottomStart = 25.dp,
                                           bottomEnd = 25.dp
                                       ))
                               ) {
                               Text("publish")
                           }
                       }

                   }

               }

                /*Premiere grande box de la colonne*/

                Box(
                    Modifier

                        .padding(18.dp, 90.dp)
                        .background(
                            color = Color.White, RoundedCornerShape(
                                topStart = 25.dp,
                                topEnd = 25.dp,
                                bottomStart = 25.dp,
                                bottomEnd = 25.dp
                            )
                        )
                        .size(400.dp, 220.dp),
                    contentAlignment = Alignment.Center

                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(0.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(22.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(35.dp, 10.dp)
                        ) {

                            /* box du nom du besoin  */

                            Box(
                                Modifier

                                    .background(
                                        color = Silver2, RoundedCornerShape(
                                            topStart = 25.dp,
                                            topEnd = 25.dp,
                                            bottomStart = 25.dp,
                                            bottomEnd = 25.dp
                                        )
                                    )
                                    .size(140.dp, 48.dp)
                            ) {
                                Text(
                                    text = "technique",
                                    fontSize = 16.sp,
                                    fontFamily = Segoeui,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Normal,
                                    style = MaterialTheme.typography.h4,
                                    modifier = Modifier.padding(18.dp, 12.dp)
                                )
                            }

                            /* box du nom de la ville  */

                            Box(
                                Modifier
                                    .background(
                                        color = Silver2, RoundedCornerShape(
                                            topStart = 25.dp,
                                            topEnd = 25.dp,
                                            bottomStart = 25.dp,
                                            bottomEnd = 25.dp
                                        )
                                    )
                                    .size(140.dp, 48.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Douala",
                                    fontSize = 16.sp,
                                    fontFamily = Segoeui,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Normal,
                                    style = MaterialTheme.typography.h6,
                                    modifier = Modifier.padding(18.dp, 12.dp)
                                )
                            }

                        }/* on sort de la ligne  */
                        /*fin de la premiere ligne de la colonne */


                        /* box du detail litteral */
                        /*debut de la deuxieme ligne de la colonne */
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(22.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(25.dp, 10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = Silver2, RoundedCornerShape(
                                            topStart = 12.dp,
                                            topEnd = 12.dp,
                                            bottomStart = 12.dp,
                                            bottomEnd = 12.dp
                                        )
                                    )
                                    .padding(20.dp, 15.dp)
                                    .size(350.dp, 60.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Besoin ",
                                    fontSize = 16.sp,
                                    fontFamily = Segoeui,
                                    fontWeight = FontWeight.Normal,
                                    style = MaterialTheme.typography.h6,
                                    modifier = Modifier.padding(25.dp, 15.dp)
                                )
                            }
                        }
                        /*fin de la deuxieme ligne de la colonne */


                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.dp),
                            modifier = Modifier.fillMaxWidth()
                                .padding(40.dp, 10.dp)
                        ) {
                            Button(onClick = { /* Action du premier bouton */ },
                                modifier = Modifier
                                    .background(
                                        color = Blue, RoundedCornerShape(
                                            topStart = 25.dp,
                                            topEnd = 25.dp,
                                            bottomStart = 25.dp,
                                            bottomEnd = 25.dp
                                        ))
                            ) {

                                Text("modify")
                            }

                            Button( onClick = { /* Action à exécuter lors du clic */ },
                                modifier = Modifier
                                    .background(
                                        color = Pink, RoundedCornerShape(
                                            topStart = 25.dp,
                                            topEnd = 25.dp,
                                            bottomStart = 25.dp,
                                            bottomEnd = 25.dp
                                        ))

                            ) {
                                Text("delete")
                            }

                            Button(onClick = { /* Action du troisième bouton */ },
                                modifier = Modifier
                                    .background(
                                        color = Bordeaux, RoundedCornerShape(
                                            topStart = 25.dp,
                                            topEnd = 25.dp,
                                            bottomStart = 25.dp,
                                            bottomEnd = 25.dp
                                        ))
                            ) {
                                Text("publish")
                            }
                        }

                    }

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




