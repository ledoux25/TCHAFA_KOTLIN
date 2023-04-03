package com.example.tchafa

import android.media.Image
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.ui.theme.PrimaryGreen
import com.example.tchafa.ui.theme.TCHAFATheme
import com.example.tchafa.ui.theme.White

@Composable
fun SplachScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = PrimaryGreen),

    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        ) 
        {
            
            Text(
                text = "TCHAFA",
                fontFamily = FontFamily.Serif,
                color= White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Image(
                painter = painterResource(R.drawable.chafa),
                contentDescription = "My Image",
                modifier = Modifier
                    .size(500.dp)

            )
            Text(
                text = "SIMPLIFY THE WAY YOU WORK",
                color = White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )


        }
    }
    OnboardingScreen()

}

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
    // TODO: This state should be hoisted
   // var shouldShowOnboarding by remember { mutableStateOf(true) }

    Row(

        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier
                .size(150.dp)
                .padding(vertical = 40.dp,),

            onClick = {},




            shape = RoundedCornerShape(40.dp)

        ) {

            Text("BEGIN", Modifier.size(65.dp, 20.dp),
                color = Color.White,
                fontSize = 17.sp,
                fontFamily = FontFamily.Serif

            )

        }
    }

}


@Preview(showBackground = true)
@Composable
fun SplachScreenPreview() {
    TCHAFATheme {
        SplachScreen()

    }
}