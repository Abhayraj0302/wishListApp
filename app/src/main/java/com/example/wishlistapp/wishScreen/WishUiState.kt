package com.example.wishlistapp.wishScreen

data class WishUiState (
    val WishName : String = "",
    val NumberOfItem : String = "",
    val isSaved : Boolean = false,
    val BackButtonPresses : Boolean = false
)