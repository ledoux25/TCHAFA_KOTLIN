package com.example.tchafa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tchafa.ui.theme.TCHAFATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        mainView()
        }
    }
}

@Composable
fun mainView()
{
    Surface(
        modifier = Modifier.fillMaxWidth()
                           .fillMaxHeight()
                           .fillMaxSize()
                           .padding(8.dp),
        color = Color.Gray
    ) {

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    mainView()
}