package com.example.wishlistapp.addwish

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wishlistapp.ui.theme.AppBackground
import com.example.wishlistapp.ui.theme.CardBackground

@Composable
fun AddWishScreen(
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Card(
            modifier = Modifier
                .height(300.dp)
                .padding(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = CardBackground
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = {
                        Text("Enter your wish")
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = {
                        Text("Enter your Count")
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {}
                ) {
                    Text(
                        "Add Wish", fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
        }


    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AddWishScreenPreview() {
    val navController = rememberNavController()
    AddWishScreen(navController = navController)
}
