package com.example.wishlistapp.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wishlistapp.home.HomeScreen
import com.example.wishlistapp.home.homeViewModel
import com.example.wishlistapp.wishScreen.addWishScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.home.route
    ) {
        composable(
            NavRoutes.home.route
        ) {
            val viewmodel : homeViewModel = viewModel()
            HomeScreen(
                navController = navController,
                onAddWishClick = {
                    navController.navigate(NavRoutes.addwish.route)
                },
                vm = viewmodel
            )
        }
        composable(
            NavRoutes.addwish.route,
        ) {
            addWishScreen(navController = navController)
        }
    }
}

