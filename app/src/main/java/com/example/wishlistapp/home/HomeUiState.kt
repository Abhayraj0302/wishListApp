package com.example.wishlistapp.home

import com.example.wishlistapp.data.wishListItems

data class HomeUiState (
    val wishListItems: List<wishListItems> = listOf(
        wishListItems("Get a CLS 63" ,4),
        wishListItems("Get a internship" , 2),
        wishListItems("Get a house", 7),
        wishListItems("Get a GLS 63" ,4),
        wishListItems("Get a KAWASHAKI" , 2),
        wishListItems("Get a BIKE", 7),

    )
)
