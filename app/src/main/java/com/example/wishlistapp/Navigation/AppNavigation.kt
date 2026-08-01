package com.example.wishlistapp.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wishlistapp.WishViewModel.WishlistViewModel
import com.example.wishlistapp.addwish.AddWishScreen
import com.example.wishlistapp.home.HomeScreen



@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val wishlistViewModel: WishlistViewModel = viewModel(factory = WishlistViewModel.Factory)

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route
    ) {

        composable(
            route = NavRoutes.Home.route,

            enterTransition = {
                scaleIn(
                    animationSpec = tween(220),
                    initialScale = 1.1f
                ) + fadeIn(
                    animationSpec = tween(220)
                )
            },

            exitTransition = {
                scaleOut(
                    animationSpec = tween(220),
                    targetScale = 0.9f
                ) + fadeOut(
                    animationSpec = tween(220)
                )
            },

            popEnterTransition = {
                scaleIn(
                    animationSpec = tween(220),
                    initialScale = 0.9f
                ) + fadeIn(
                    animationSpec = tween(220)
                )
            },

            popExitTransition = {
                scaleOut(
                    animationSpec = tween(220),
                    targetScale = 1.1f
                ) + fadeOut(
                    animationSpec = tween(220)
                )
            }
        ) {
            HomeScreen(
                navController = navController,
                onAddWishClick = {
                    navController.navigate(
                        NavRoutes.AddWish.route
                    )
                },
                vm = wishlistViewModel
            )
        }


        composable(
            route = NavRoutes.AddWish.route,

            enterTransition = {
                scaleIn(
                    animationSpec = tween(220),
                    initialScale = 1.1f
                ) + fadeIn(
                    animationSpec = tween(220)
                )
            },

            exitTransition = {
                scaleOut(
                    animationSpec = tween(220),
                    targetScale = 0.9f
                ) + fadeOut(
                    animationSpec = tween(220)
                )
            },

            popEnterTransition = {
                scaleIn(
                    animationSpec = tween(220),
                    initialScale = 0.9f
                ) + fadeIn(
                    animationSpec = tween(220)
                )
            },

            popExitTransition = {
                scaleOut(
                    animationSpec = tween(220),
                    targetScale = 1.1f
                ) + fadeOut(
                    animationSpec = tween(220)
                )
            }
        ) {
            AddWishScreen(
                vm = wishlistViewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}