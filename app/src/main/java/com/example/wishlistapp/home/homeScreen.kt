package com.example.wishlistapp.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wishlistapp.R
import com.example.wishlistapp.home.components.AppTopBar
import com.example.wishlistapp.home.components.WishListCard
import com.example.wishlistapp.ui.theme.AppBackground
import com.example.wishlistapp.ui.theme.LightGreen

@Composable
fun HomeScreen(
    navController: NavHostController,
    onAddWishClick: () -> Unit,
    vm: HomeViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackground)
    ) {
        Scaffold(
            topBar = {
                AppTopBar()
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = onAddWishClick,
                    shape = CircleShape,
                    containerColor = LightGreen
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_add_24),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        ) { paddingValues ->
            val uiState by vm.uiState.collectAsState()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppBackground)
                    .padding(paddingValues)

            ) {
                if (uiState.wishListItems.isEmpty()) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 30.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Their's no specific time to make a wish \uD83E\uDE84",
                                modifier = Modifier.padding(16.dp),
                                color = Color.LightGray,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp
                            )
                        }
                    }
                } else {
                    items(
                        uiState.wishListItems,
                        key = { it.id }
                    ) { item ->
                        SwipeToDismissBox(
                            state = rememberSwipeToDismissBoxState(
                                confirmValueChange = { dismissValue ->

                                    if (dismissValue == SwipeToDismissBoxValue.EndToStart) {
                                        vm.onEvent(
                                            HomeEvent.DeleteWish(item)
                                        )
                                    }

                                    true
                                }
                            ),
                            backgroundContent = {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    contentAlignment = Alignment.CenterEnd
                                ) {
                                    Text(
                                        text = "Delete",
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,

                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(12.dp))
                                            .height(80.dp)
                                            .background(color = Color.Red)
                                            .padding(16.dp)
                                    )
                                }
                            }
                        ) {
                            // Your existing card
                            WishListCard(item)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController, {}, vm = HomeViewModel())
}
