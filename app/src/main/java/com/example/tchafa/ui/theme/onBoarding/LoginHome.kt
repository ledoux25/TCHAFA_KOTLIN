package com.example.tchafa.ui.theme.onBoarding


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.ui.theme.TCHAFATheme


@Composable
fun CardWithTextAndButtons() {
    Card(
        modifier = Modifier
            .padding(40.dp)
            .fillMaxWidth()
    ) {
        Column(
            Modifier.padding(20.dp)
        ) {
            Text(
                text = "You Part-time job Is \t\t\t\t\t\t " +
                        "Waiting you",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Blue,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text =  "\t\t\t\t\t\tFind interesting jobs offers from \t\t\t\t\t\t" +
                        "\t\t\t\t\t\t\tlocal individuals",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier.padding(bottom = 18.dp)
            )
            Spacer(modifier = Modifier.width(100.dp))
            Row {
                Button(
                    onClick = { /* Action associée au premier bouton */ },
                    shape = RoundedCornerShape(50),

                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Text( "Sign Up",)
                }
                Spacer(modifier = Modifier.width(80.dp))
                Button(
                    onClick = { /* Action associée au deuxième bouton */ },
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text("Login")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardWithTextAndButtonsPreview() {
    TCHAFATheme {
        CardWithTextAndButtons()    }
}