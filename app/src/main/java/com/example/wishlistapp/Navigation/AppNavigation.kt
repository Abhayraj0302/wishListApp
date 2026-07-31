package com.example.wishlistapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wishlistapp.addwish.AddWishScreen
import com.example.wishlistapp.home.HomeScreen
import com.example.wishlistapp.home.HomeViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route
    ) {
        composable(
            NavRoutes.Home.route
        ) {
            val viewModel: HomeViewModel = viewModel()
            HomeScreen(
                navController = navController,
                onAddWishClick = {
                    navController.navigate(NavRoutes.AddWish.route)
                },
                vm = viewModel
            )
        }
        composable(
            NavRoutes.AddWish.route,
        ) {
            AddWishScreen(navController = navController)
        }
    }
}
