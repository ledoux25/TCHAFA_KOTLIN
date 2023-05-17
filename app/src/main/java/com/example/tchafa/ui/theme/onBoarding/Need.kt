package com.example.tchafa.ui.theme.onBoarding


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tchafa.ui.theme.TCHAFATheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack


@Composable
fun MyFormScreen() {
    IconButton(onClick = { /* action de retour */ }) {
        Icon(Icons.Filled.ArrowBack, contentDescription = "Retour")
    }
    Spacer(modifier = Modifier.height(90.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(23.dp)
    ) {
        Text(
            text =  "Create Your Need",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 18.dp)
        )
            Text(
                text =  "in less than a minute and\n" +
                        "publish it ",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 18.dp)
            )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text =  "\t \t \t \t \t fill all the blank spaces !!",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 18.dp)
        )
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            text = "Titre",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { /* Gestionnaire de changement de valeur */ },
            label = { Text("") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Localisation",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { /* Gestionnaire de changement de valeur */ },
            label = { Text("") },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Secteur",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { /* Gestionnaire de changement de valeur */ },
            label = { Text("") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Description",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { /* Gestionnaire de changement de valeur */ },
            label = { Text("") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = { /* Action lors de l'appui sur le bouton */ },
            modifier = Modifier

                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("Create")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyFormScreenPreview() {
    TCHAFATheme {
        MyFormScreen()    }
}