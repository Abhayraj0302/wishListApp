package com.example.wishlistapp.addwish

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wishlistapp.WishViewModel.WishlistViewModel
import com.example.wishlistapp.data.WishItem
import com.example.wishlistapp.ui.theme.AppBackground
import com.example.wishlistapp.ui.theme.CardBackground

@Composable
fun AddWishScreen(
    vm : WishlistViewModel,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    val uistate by vm.addWishUiState.collectAsState()
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
                    value = uistate.wishName,
                    onValueChange = {it->
                        vm.onWishEvent(
                            AddWishEvent.WishNameChanged(it)
                        )

                    },
                    label = {
                        Text("Make your wish")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    textStyle = LocalTextStyle.current.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedPlaceholderColor = Color.White,
                        unfocusedPlaceholderColor = Color.White,
                        focusedBorderColor = Color.LightGray,
                        unfocusedBorderColor = Color.LightGray,
                        focusedLabelColor = Color.LightGray,
                        unfocusedLabelColor = Color.LightGray

                    ),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = uistate.numberOfItem,
                    onValueChange = {it->
                        vm.onWishEvent(
                            AddWishEvent.NumberOfItemChanged(it)
                        )
                    },
                    label = {
                        Text("Enter your wish Count")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    textStyle = LocalTextStyle.current.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedPlaceholderColor = Color.White,
                        unfocusedPlaceholderColor = Color.White,
                        focusedBorderColor = Color.LightGray,
                        unfocusedBorderColor = Color.LightGray,
                        focusedLabelColor = Color.LightGray,
                        unfocusedLabelColor = Color.LightGray
                    ),
                    singleLine = true

                )
                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                            val count = uistate.numberOfItem.toIntOrNull() ?: 0
                            val wish = WishItem(
                                wishname = uistate.wishName,
                                count = count
                            )
                            vm.addWish(wish)
                        Toast.makeText(context , "Wish Added" , Toast.LENGTH_SHORT).show()
                        onBackClick()
                    }
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
    AddWishScreen( vm   = WishlistViewModel() , {})
}
