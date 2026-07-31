package com.example.wishlistapp.Navigation

sealed class NavRoutes(val route : String){
    data object home : NavRoutes("HOME")
    data object addwish : NavRoutes("ADDWISH")
}