package com.example.tchafa.ui.theme.onBoarding

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.R
import com.example.tchafa.ui.theme.*


data class PublicationBesoin(
    val imageVector: Painter,
    val nom:String,
    val titre:String, )


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Candidatures(
    PublicationBesoin: List<PublicationBesoin>
){
    LazyColumn{
        stickyHeader{
            TopBarApp()
        }
        items(PublicationBesoin){
            CardBesoin(it)
        }

    }
}
@Composable
fun TopBarApp(){
    Box{
        Row(
            Modifier
                .fillMaxWidth()
                .background(textcolor)
                .padding(50.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp, 32.dp)
                )
            }
            // Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .padding(1.dp),
                //horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Candidature",
                    style = MaterialTheme.typography.body1.copy(
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp
                    )
                )
            }

        }
    }

}
@Composable
fun CardBesoin(PublicationBesoin : PublicationBesoin){
    Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ){
        Column() {
            Row(){
                Image(
                    painter = PublicationBesoin.imageVector,
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, textcolor, CircleShape)
                        .height(84.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .weight(0.8f),
                ) {
                    Text(
                        modifier=Modifier.padding(3.dp),
                        text=PublicationBesoin.titre,
                        color = Color.Black,
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        modifier=Modifier.padding(3.dp),
                        text = PublicationBesoin.nom,
                        color = Color.Black,
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 15.sp
                        )
                    )


                }
            }
            Row(

                verticalAlignment=Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier= Modifier
                        .width(150.dp)
                        .padding(horizontal = 12.dp)




                ) {
                Text(
                    "declened",
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontSize = 12.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                )
            }

                Button(
                    onClick = { /*TODO*/ },
                    modifier= Modifier
                        .width(150.dp)
                        .padding(horizontal = 12.dp),
                    colors= androidx.compose.material.ButtonDefaults.buttonColors(
                        contentColor = pink
                    )

                ) {
                    Text(
                        "Voir profil",
                        style = MaterialTheme.typography.subtitle1.copy(
                            fontSize = 12.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    TCHAFATheme{
        TopBarApp()
        Candidatures(PublicationBesoin = listOf(
            PublicationBesoin(
                imageVector = painterResource(R.drawable.mouf),
                titre= "Plombier",
                nom = "Toko michel",
            ),
            PublicationBesoin(
           imageVector = painterResource(R.drawable.mouf),
            titre= "Electricien",
            nom = "joseph ledoux",
        ),
            PublicationBesoin(
                imageVector = painterResource(R.drawable.mouf),
                titre= "Electricien",
                nom = "chiemo patrice",
            ),
            PublicationBesoin(
                imageVector = painterResource(R.drawable.mouf),
                titre= "Menagere",
                nom = "Malonju laure",
            ),
            PublicationBesoin(
                imageVector = painterResource(R.drawable.mouf),
                titre= "BabySister",
                nom = " pouani justin",
            ),


            )

        )
    }
}