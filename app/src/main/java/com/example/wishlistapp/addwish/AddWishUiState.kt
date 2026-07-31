package com.example.wishlistapp.addwish

data class AddWishUiState(
    val WishName: String = "",
    val NumberOfItem: String = "",
    val isSaved: Boolean = false,
    val BackButtonPresses: Boolean = false
)
