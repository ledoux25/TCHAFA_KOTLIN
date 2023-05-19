package com.example.tchafa

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Men() {

    Scaffold(
       /* bottomBar = {
            Button(
                onClick = { /* Action à effectuer lorsque le bouton est cliqué */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("APPLY")
            }
        },*/

        topBar = {
            TopAppBar(
                title = {  UnderlinedTitle(text = "Job Details")},
                navigationIcon = {
                    IconButton(onClick = { /* Action pour le bouton de retour */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.bac),
                            contentDescription = "My Image",
                            modifier = Modifier
                                .size(44.dp)
                                .padding(8.dp)
                        )
                    }
                },
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        }

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {

            ToImage()
            Text(
                text = "published by:Kanteu Maxime",
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalCards()
            Spacer(modifier = Modifier.height(16.dp))
            TitreSouligne("Description" , "Mon texte qui va en dessousgggggggggggggggg" +
                    "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                    "ggggggggggggggggggggggggggggggggggggggggggg")
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = { /* Action à effectuer lorsque le bouton est cliqué */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("APPLY")
            }
        }

    }

}

@Composable
fun UnderlinedTitle(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline,
        fontSize = 20.sp

    )
}

@Composable
fun ToImage() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.maximeh),
            contentDescription = "My Image",
            modifier = Modifier
                .height(100.dp)
                .width(200.dp)
                .padding(top = 16.dp)
        )
        Text(
            text = "House Keeper",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
fun TitreSouligne(titre: String, texte: String) {
    Column(Modifier.padding(16.dp)) {
        Text(
            text = titre,
            style = MaterialTheme.typography.h5,

        )
        Text(
            text = texte,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
fun HorizontalCards() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier.padding(16.dp).width(120.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Image(
                    painterResource(id = R.drawable.marker_32px),
                    contentDescription = "Image 1",
                    modifier = Modifier.size(width = 50.dp, height = 30.dp).scale(1.5f)
                )
                Text(
                    text = "Localisation",
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "DOUALA",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
        Card(
            modifier = Modifier.padding(16.dp).width(120.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Image(
                    painterResource(id = R.drawable.dollar30px),
                    contentDescription = "Image 2",
                    modifier = Modifier.size(width = 50.dp, height = 30.dp).scale(1.5f)
                )
                Text(
                    text = "Salary",
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "30000FCFA",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Details(){

    Men()
}