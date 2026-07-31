package com.example.wishlistapp.navigation

sealed class NavRoutes(val route: String) {
    data object Home : NavRoutes("HOME")
    data object AddWish : NavRoutes("ADDWISH")
}
