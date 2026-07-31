package com.example.wishlistapp.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wishlistapp.R
import com.example.wishlistapp.ui.theme.AppBackground
import com.example.wishlistapp.ui.theme.LightGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    TopAppBar(
        modifier = Modifier.height(100.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppBackground,
            titleContentColor = AppBackground,
            navigationIconContentColor = AppBackground
        ),
        title = {
            Row() {
                Text("WishList", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = LightGreen)
                Text("App", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        },
       actions = {
           IconButton(onClick = {}) {
               Icon(
                   painter = painterResource(id = R.drawable.person),
                   contentDescription = null,
                   tint = LightGreen
               )
           }
       }
    )
}

@Preview(showSystemUi = true)
@Composable
fun AppTopBarPreview(modifier: Modifier = Modifier) {
    AppTopBar()
}
